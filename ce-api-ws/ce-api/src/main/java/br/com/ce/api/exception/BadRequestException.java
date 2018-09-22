package br.com.ce.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class BadRequestException.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception 
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new bad request exception.
	 */
	public BadRequestException() 
	{
		
	}
}
