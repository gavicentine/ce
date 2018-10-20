/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.ce.common.model.UserContext;

// TODO: Auto-generated Javadoc
/**
 * The Class Request.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Request
{

	/** The user context. */
	private UserContext userContext = null;

	/**
	 * Instantiates a new request.
	 */
	public Request()
	{
	}

	/**
	 * Instantiates a new request.
	 *
	 * @param userContext the user context
	 */
	public Request(UserContext userContext)
	{
		setUserContext(userContext);
	}

	/**
	 * Sets the user context.
	 *
	 * @param userContext the new user context
	 */
	public void setUserContext(UserContext userContext)
	{
		this.userContext = userContext;
	}

	/**
	 * Gets the user context.
	 *
	 * @return the user context
	 */
	public UserContext getUserContext()
	{
		return userContext;
	}
}
