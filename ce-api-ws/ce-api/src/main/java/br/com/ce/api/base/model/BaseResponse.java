package br.com.ce.api.base.model;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseResponse.
 */
public class BaseResponse {

	/** The token. */
	private String token;
	
	/** The status. */
	private Status status;
	
	
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
	 * Instantiates a new usuario response.
	 */
	public BaseResponse() {
		super();
	}

	
	/**
	 * Instantiates a new base response.
	 *
	 * @param status the status
	 */
	public BaseResponse(Status status) {
		super();
		this.status = status;
	}

	/**
	 * Instantiates a new usuario response.
	 *
	 * @param status the status
	 * @param token the token
	 */
	public BaseResponse(Status status, String token) {
		super();
		this.status = status;
		this.token = token;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
