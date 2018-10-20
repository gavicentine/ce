/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ce.common.model.Message;
import br.com.ce.common.model.MessageInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class InternalResponse.
 */
public class InternalResponse
{

	/** The status. */
	private Status status = Status.OperationSuccess;

	/** The status context map. */
	private Map<String, Object> statusContextMap;

	/** The message info list. */
	private List<MessageInfo> messageInfoList;

	/**
	 * The Enum Status.
	 */
	public enum Status
	{

		/** The Operation success. */
		OperationSuccess,

		/** The Exception error. */
		ExceptionError,

		/** The System error. */
		SystemError,

		/** The Persistence error. */
		PersistenceError,

		/** The Validation error. */
		ValidationError,

		/** The Optimistic locking error. */
		OptimisticLockingError,

		/** The Version not found error. */
		VersionNotFoundError,

		/** The No rows found error. */
		NoRowsFoundError,

		/** The No rows updated error. */
		NoRowsUpdatedError,

		/** The No rows removed error. */
		NoRowsRemovedError,

		/** The No rows inserted error. */
		NoRowsInsertedError,

		/** The Singleton select error. */
		SingletonSelectError,

		/** The Query builder error. */
		QueryBuilderError,

		/** The Unspecified error. */
		UnspecifiedError,

		/** The External error. */
		ExternalError
	}

	/**
	 * Instantiates a new internal response.
	 *
	 * @param newStatus the new status
	 */
	public InternalResponse(Status newStatus)
	{
		status = newStatus;
	}

	/**
	 * Instantiates a new internal response.
	 */
	public InternalResponse()
	{
	}

	/**
	 * Gets the status context map.
	 *
	 * @return the status context map
	 */
	public Map<String, Object> getStatusContextMap()
	{
		if (statusContextMap == null)
		{
			statusContextMap = new HashMap<String, Object>();
		}

		return statusContextMap;
	}

	/**
	 * Gets the status context object.
	 *
	 * @param key the key
	 * @return the status context object
	 */
	public Object getStatusContextObject(String key)
	{
		return getStatusContextMap().get(key.toLowerCase());
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
	 * Removes the status context object.
	 *
	 * @param key the key
	 */
	public void removeStatusContextObject(String key)
	{
		getStatusContextMap().remove(key.toLowerCase());
	}

	/**
	 * Adds the status context object.
	 *
	 * @param key the key
	 * @param obj the obj
	 */
	public void addStatusContextObject(String key, Object obj)
	{
		getStatusContextMap().put(key.toLowerCase(), obj);
	}

	/**
	 * Checks if is in error.
	 *
	 * @return true, if is in error
	 */
	public boolean isInError()
	{
		// return this.status.name().toLowerCase().contains("error") ? true : false;\
		return status != Status.OperationSuccess;
	}

	/**
	 * Adds the messages.
	 *
	 * @param messageInfoList the message info list
	 */
	public void addMessages(List<MessageInfo> messageInfoList)
	{
		getMessageInfoList().addAll(messageInfoList);
	}

	/**
	 * Adds the message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param level the level
	 */
	public void addMessage(String code, Message.MessageSeverity severity, Message.MessageLevel level)
	{
		getMessageInfoList().add(new MessageInfo(code, severity, level));
	}

	/**
	 * Adds the message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param level the level
	 * @param args the args
	 */
	public void addMessage(String code, Message.MessageSeverity severity, Message.MessageLevel level, Object[] args)
	{
		getMessageInfoList().add(new MessageInfo(code, severity, level, args));
	}

	/**
	 * Adds the object error message.
	 *
	 * @param code the code
	 */
	public void addObjectErrorMessage(String code)
	{
		this.addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Object);
	}

	/**
	 * Adds the object error message.
	 *
	 * @param code the code
	 * @param args the args
	 */
	public void addObjectErrorMessage(String code, Object[] args)
	{
		this.addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Object, args);
	}

	/**
	 * Adds the field error message.
	 *
	 * @param code the code
	 */
	public void addFieldErrorMessage(String code)
	{
		this.addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Field);
	}

	/**
	 * Adds the field error message.
	 *
	 * @param code the code
	 * @param args the args
	 */
	public void addFieldErrorMessage(String code, Object[] args)
	{
		this.addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Field, args);
	}

	/**
	 * Adds the internal message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param text the text
	 */
	public void addInternalMessage(String code, Message.MessageSeverity severity, String text)
	{
		MessageInfo mi = MessageInfo.internalMessage(code, severity, text);
		getMessageInfoList().add(mi);
	}

	/**
	 * Merge.
	 *
	 * @param internalResponse the internal response
	 */
	public void merge(InternalResponse internalResponse)
	{
		if (getStatus() == Status.OperationSuccess)
		{
			setStatus(internalResponse.getStatus());
		}

		getStatusContextMap().putAll(internalResponse.getStatusContextMap());
		getMessageInfoList().addAll(internalResponse.getMessageInfoList());
	}

	/**
	 * Merge.
	 *
	 * @param response the response
	 */
	public void merge(Response response)
	{
		if (response != null)
		{
			getMessageInfoList().addAll(response.getMessageInfoList());
			if (!response.isOperationSuccess())
			{
				setStatus(Status.UnspecifiedError);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "InternalResponse [getStatusContextMap()=" + getStatusContextMap() + ", getStatus()=" + getStatus()
				+ ", getMessageInfoList()=" + getMessageInfoList()
				+ ", isInError()=" + isInError() + "]";
	}

}
