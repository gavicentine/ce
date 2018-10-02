package br.com.ce.api.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthResponse.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse
{
	
	/** The message. */
	private String message;
	
	/** The status. */
	private Status status;
	
	/** The exception type. */
	private String exceptionType;
	
	/** The token. */
	private String token;
	
	/** The claims. */
	private Jws<Claims> claims;

	/**
	 * The Enum Status.
	 */
	public enum Status
	{		
		/** The success. */
		SUCCESS, 
		/** The expired. */
		EXPIRED, 
		/** The error. */
		ERROR
	}

	/**
	 * Instantiates a new auth response.
	 */
	public AuthResponse()
	{
	}

	/**
	 * Instantiates a new auth response.
	 *
	 * @param token the token
	 */
	public AuthResponse(String token)
	{
		this.token = token;
		status = Status.SUCCESS;
	}

	/**
	 * Instantiates a new auth response.
	 *
	 * @param claims the claims
	 */
	public AuthResponse(Jws<Claims> claims)
	{
		this.claims = claims;
		status = Status.SUCCESS;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus()
	{
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status)
	{
		this.status = status;
	}

	/**
	 * Gets the exception type.
	 *
	 * @return the exception type
	 */
	public String getExceptionType()
	{
		return exceptionType;
	}

	/**
	 * Sets the exception type.
	 *
	 * @param exceptionType the new exception type
	 */
	public void setExceptionType(String exceptionType)
	{
		this.exceptionType = exceptionType;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken()
	{
		return token;
	}

	/**
	 * Sets the jwt.
	 *
	 * @param token the new jwt
	 */
	public void setJwt(String token)
	{
		this.token = token;
	}

	/**
	 * Gets the claims.
	 *
	 * @return the claims
	 */
	public Jws<Claims> getClaims()
	{
		return claims;
	}

	/**
	 * Sets the jws.
	 *
	 * @param claims the new jws
	 */
	public void setJws(Jws<Claims> claims)
	{
		this.claims = claims;
	}
}
