package br.com.ce.api.auth.controller;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ce.api.auth.config.TokenManager;
import br.com.ce.api.auth.model.AuthResponse;
import br.com.ce.api.auth.model.AuthResponse.Status;

@RestController
@RequestMapping(value = "/auth")
public class AuthJWTController
{
	private static final Logger LOG = LoggerFactory.getLogger(AuthJWTController.class);

	@Resource
	private TokenManager tokenManager;

	@RequestMapping(value = "/ping", method = RequestMethod.POST)
	@ResponseBody
	public AuthResponse ping()
	{
		// It is a example service protected by authentication
		AuthResponse response = new AuthResponse();
		response.setStatus(Status.SUCCESS);
		response.setMessage("Ping Ok!");
		return response;
	}

	@RequestMapping(value = "/authenticate", method = POST)
	@ResponseBody
	public AuthResponse authenticate(@RequestBody Map<String, Object> credentials)
			throws UnsupportedEncodingException
	{
		LOG.info("Credentials to authenticate:");
		for (Entry<String, Object> entry : credentials.entrySet())
		{
			LOG.info("{}: {}", entry.getKey(), entry.getValue());
		}

		// Add here logic to authenticate and guarantee that credentials are valid

		return new AuthResponse(tokenManager.generateToken(credentials));
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	@ResponseBody
	public AuthResponse refresh(@RequestParam String expiredToken)
	{
		LOG.info("Refreshing token");
		if (tokenManager.isTokenExpired(expiredToken))
		{
			return new AuthResponse(tokenManager.refreshToken(expiredToken));
		}

		AuthResponse response = new AuthResponse();
		response.setStatus(Status.ERROR);
		response.setMessage("Token is invalid");
		return response;
	}

	@RequestMapping(value = "/expired", method = RequestMethod.POST)
	@ResponseBody
	public AuthResponse expired()
	{
		AuthResponse response = new AuthResponse();
		response.setStatus(Status.EXPIRED);
		response.setMessage("Token is expired");
		return response;
	}

	@RequestMapping(value = "/forbidden", method = RequestMethod.POST)
	@ResponseBody
	public AuthResponse forbidden()
	{
		AuthResponse response = new AuthResponse();
		response.setStatus(Status.ERROR);
		response.setMessage("Token is invalid!");
		return response;
	}
}
