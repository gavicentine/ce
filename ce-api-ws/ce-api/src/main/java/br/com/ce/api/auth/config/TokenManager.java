package br.com.ce.api.auth.config;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class TokenManager.
 */
@Component
public class TokenManager
{
	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(TokenManager.class);
	
	/** The Constant ROLES. */
	private static final String ROLES = "roles";
	
	/** The Constant CUSTOMER. */
	private static final String CUSTOMER = "customer";
	
	/** The Constant APP. */
	private static final String APP = "app";

	/** The secret key factory. */
	@Resource
	private SecretKeyFactory secretKeyFactory;

	/** The time to expire. */
	@Value("${time.to.expire}")
	private Integer timeToExpire;

	/**
	 * Generate token.
	 *
	 * @param credentials the credentials
	 * @return the string
	 */
	public String generateToken(Map<String, Object> credentials)
	{
		
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		
		LOG.info("Token created at: {}", now);
		
		calendar.add(Calendar.SECOND, timeToExpire);
		
		Date exp = calendar.getTime();
		LOG.info("Token expire  at: {}", exp);
		

		return Jwts.builder()
				.setClaims(credentials)
				.setIssuedAt(now)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, secretKeyFactory.getHS512SecretBytes())
				.compact();
	}

	/**
	 * Refresh token.
	 *
	 * @param tokenExpired the token expired
	 * @return the string
	 */
	public String refreshToken(String tokenExpired)
	{
		Map<String, Object> credentialsFromToken = fetchCredentialsFromExpiredToken(tokenExpired);
		Map<String, Object> credentials = new HashMap<>();
		credentials.put(APP, credentialsFromToken.get(APP));
		credentials.put(CUSTOMER, credentialsFromToken.get(CUSTOMER));
		credentials.put(ROLES, credentialsFromToken.get(ROLES));
		return generateToken(credentials);
	}


	/**
	 * Fetch credentials.
	 *
	 * @param token the token
	 * @return the claims
	 */
	public Claims fetchCredentials(String token)
	{
		if ((token == null) || token.isEmpty())
		{
			LOG.error("Token is null or empty.");
			return null;
		}

		try
		{
			// Try parser token, if it can get then it is valid
			Jws<Claims> claims = Jwts.parser()
					.setSigningKeyResolver(secretKeyFactory.getSigningKeyResolver())
					.parseClaimsJws(token);
			return claims.getBody();
		}
		catch (ExpiredJwtException e)
		{
			LOG.error("Token is valid but it has expired.", e);
			return e.getClaims();
		}
		catch (JwtException e)
		{
			LOG.error("Token is invalid.", e);
			return null;
		}

	}

	/**
	 * Checks if is token expired.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	public Boolean isTokenExpired(String token)
	{
		if ((token == null) || token.isEmpty())
		{
			LOG.error("Token is null or empty");
			return false;
		}

		try
		{
			// Try parser token, if it can get then it is not expired
			Jws<Claims> claims = Jwts.parser()
					.setSigningKeyResolver(secretKeyFactory.getSigningKeyResolver())
					.parseClaimsJws(token);

			LOG.info("Credentials: {}", claims.getBody());

			return false;
		}
		catch (ExpiredJwtException e)
		{
			LOG.error("Token is valid but it is expired", e);
			return true;
		}
	}

	/**
	 * Fetch credentials from expired token.
	 *
	 * @param tokenExpired the token expired
	 * @return the map
	 */
	private Map<String, Object> fetchCredentialsFromExpiredToken(String tokenExpired)
	{
		Claims claims = null;

		try
		{
			Jwts.parser()
					.setSigningKeyResolver(secretKeyFactory.getSigningKeyResolver())
					.parseClaimsJws(tokenExpired);
		}
		catch (ExpiredJwtException e)
		{
			claims = e.getClaims();
		}
		catch (JwtException e)
		{
			return null;
		}

		Map<String, Object> credentials = new HashMap<>();
		if (claims == null)
		{
			return credentials;
		}

		for (Entry<String, Object> entry : claims.entrySet())
		{
			credentials.put(entry.getKey(), entry.getValue());
		}

		return credentials;
	}
}
