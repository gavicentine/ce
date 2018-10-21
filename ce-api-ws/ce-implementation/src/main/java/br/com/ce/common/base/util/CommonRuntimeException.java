/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.base.util;

import java.util.ArrayList;
import java.util.List;

import br.com.ce.common.model.MessageInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonRuntimeException.
 */
public class CommonRuntimeException extends RuntimeException
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message info list. */
	private List<MessageInfo> messageInfoList;

	/**
	 * Instantiates a new common runtime exception.
	 */
	public CommonRuntimeException()
	{
	}

	/**
	 * Instantiates a new common runtime exception.
	 *
	 * @param message the message
	 */
	public CommonRuntimeException(String message)
	{
		super(message);
	}

	/**
	 * Instantiates a new common runtime exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public CommonRuntimeException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Instantiates a new common runtime exception.
	 *
	 * @param cause the cause
	 */
	public CommonRuntimeException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * Gets the message info list.
	 *
	 * @return the message info list
	 */
	public List<MessageInfo> getMessageInfoList()
	{
		if (messageInfoList == null)
		{
			messageInfoList = new ArrayList<MessageInfo>();
		}

		return messageInfoList;
	}

	/**
	 * Sets the message info list.
	 *
	 * @param messageInfoList the new message info list
	 */
	public void setMessageInfoList(List<MessageInfo> messageInfoList)
	{
		this.messageInfoList = messageInfoList;
	}
}
