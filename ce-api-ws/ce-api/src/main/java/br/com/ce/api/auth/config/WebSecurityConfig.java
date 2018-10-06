package br.com.ce.api.auth.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;

// TODO: Auto-generated Javadoc
/**
 * The Class WebSecurityConfig.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);

	/** The token manager. */
	@Resource
	private TokenManager tokenManager;

	/** The credential config. */
	@Resource
	private CredentialConfig credentialConfig;

	/** The Constant SERVICES_IGNORED. */
	private static final List<String> SERVICES_IGNORED = Arrays.asList("/auth/authenticate", "/auth/refresh", "/user/login", "/user/register");

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.csrf()
				.disable()
				.addFilterBefore(new JwtValidatorFilter(), BasicAuthenticationFilter.class);
	}

	/**
	 * The Class JwtValidatorFilter.
	 */
	private class JwtValidatorFilter extends OncePerRequestFilter
	{
		
		/** The Constant TOKEN_PARAM_NAME. */
		private static final String TOKEN_PARAM_NAME = "x-auth-token";
		
		/** The Constant EXPIRED. */
		private static final String EXPIRED = "expired";
		
		/** The Constant FORBIDDEN. */
		private static final String FORBIDDEN = "forbidden";

		/* (non-Javadoc)
		 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
		 */
		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
				FilterChain filterChain) throws ServletException, IOException
		{
			// Services not require authentication
			String service = request.getServletPath();
			if (SERVICES_IGNORED.contains(service))
			{
				filterChain.doFilter(request, response);
				return;
			}

			// Try fetch credentials
			String token = request.getHeader(TOKEN_PARAM_NAME);
			String resultado;
			if ((resultado = tokenManager.validate(token)) != null) 
			{
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.addHeader("message", resultado);
				//response.get
				RequestDispatcher dispatcher = request.getRequestDispatcher(FORBIDDEN);
				dispatcher.forward(request, response);
				return;
			};
			
			//Claims credentials = tokenManager.fetchCredentials(token);
//			if (credentials == null)
//			{
//				// Token is invalid
//				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//				RequestDispatcher dispatcher = request.getRequestDispatcher(FORBIDDEN);
//				dispatcher.forward(request, response);
//				return;
//			}

			// Check if token is alive
			if (tokenManager.isTokenExpired(token))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(EXPIRED);
				dispatcher.forward(request, response);
				return;
			}

			// Match roles from token with configuration
//			LOG.info("Service accessed: {} by credentials: {}", service, credentials);
//			if (!isValidCredentials(credentials))
//			{
//				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//				RequestDispatcher dispatcher = request.getRequestDispatcher(FORBIDDEN);
//				dispatcher.forward(request, response);
//				return;
//			}

			// If all those validations is passed then call service requested
			filterChain.doFilter(request, response);
		}

		/**
		 * Checks if is valid credentials.
		 *
		 * @param claims the claims
		 * @return true, if is valid credentials
		 */
		private boolean isValidCredentials(Claims claims)
		{
			// Getting credentials
			String app = (String)claims.get("app");
			String customer = (String)claims.get("customer");
			List<String> requestRoles = Arrays.asList(((String)claims.get("roles")).split("\\|"));

			// Trying get roles by app
			String key = String.valueOf(app).toLowerCase();
			List<String> configRoles = Arrays.asList(credentialConfig.getApps().get(key).split("\\|"));
			if (configRoles == null)
			{
				// Trying get roles by app + customer
				key = String.valueOf(app + "_" + customer).toLowerCase();
				configRoles = Arrays.asList(credentialConfig.getApps().get(key).split("\\|"));
			}

			if (configRoles == null)
			{
				return false;
			}

			// Matching all roles from request with configured properties
			return configRoles.containsAll(requestRoles);
		}

	}
}
