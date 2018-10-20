/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.ce.common.model.Message;
import br.com.ce.common.model.MessageInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class Response.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Response
{

	/** The message list. */
	private List<Message> messageList = new ArrayList<Message>();

	/** The operation success. */
	private boolean operationSuccess = true;

	/**
	 * Gets the message iterator.
	 *
	 * @return the message iterator
	 */
	public Iterator<Message> getMessageIterator()
	{
		return messageList.iterator();
	}

	/**
	 * Gets the message list.
	 *
	 * @return the message list
	 */
	public List<Message> getMessageList()
	{
		return messageList;
	}

	/**
	 * Gets the message info list.
	 *
	 * @return the message info list
	 */
	public List<MessageInfo> getMessageInfoList()
	{
		List<MessageInfo> list = new ArrayList<MessageInfo>();

		for (Message msg : messageList)
		{
			list.add(msg.getMessageInfo());
		}

		return list;
	}

	/**
	 * Sets the message list.
	 *
	 * @param msgList the new message list
	 */
	public void setMessageList(List<Message> msgList)
	{
		messageList = msgList;
	}

	/**
	 * Checks if is operation success.
	 *
	 * @return true, if is operation success
	 */
	public boolean isOperationSuccess()
	{
		return operationSuccess;
	}

	/**
	 * Sets the operation success.
	 *
	 * @param operationSuccess the new operation success
	 */
	public void setOperationSuccess(boolean operationSuccess)
	{
		this.operationSuccess = operationSuccess;
	}

	/**
	 * Sets the operation success.
	 *
	 * @param iStatus the i status
	 * @return true, if successful
	 */
	public boolean setOperationSuccess(InternalResponse.Status iStatus)
	{
		switch (iStatus)
		{
			case ExceptionError:
			case SystemError:
			case PersistenceError:
			case OptimisticLockingError:
			case VersionNotFoundError:
			case SingletonSelectError:
			case UnspecifiedError:
			case ExternalError:
			{
				operationSuccess = false;
				break;
			}
			default:
			{
				operationSuccess = true;
			}
		}

		return operationSuccess;

	}

	/**
	 * Adds the message.
	 *
	 * @param msg the msg
	 */
	public void addMessage(Message msg)
	{
		messageList.add(msg);
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
		messageList.add(new Message(code, severity, level));
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
		messageList.add(new Message(code, severity, level, args));
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
	 * Adds the operation failed message.
	 *
	 * @param code the code
	 * @param args the args
	 */
	public void addOperationFailedMessage(String code, Object... args)
	{
		this.addObjectErrorMessage(code, args);
		this.setOperationSuccess(false);
	}

	/**
	 * Adds the operation failed message.
	 *
	 * @param messages the messages
	 */
	public void addOperationFailedMessage(List<MessageInfo> messages)
	{
		addMessages(messages);
		this.setOperationSuccess(false);
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
	 * @param propertyName the property name
	 */
	public void addFieldErrorMessage(String code, String propertyName)
	{
		Message msg = new Message(code, Message.MessageSeverity.Error, Message.MessageLevel.Field);
		msg.getMessageInfo().setRelatedPropertyName(propertyName);
		this.addMessage(msg);
	}

	/**
	 * Adds the field error message.
	 *
	 * @param code the code
	 * @param propertyName the property name
	 * @param args the args
	 */
	public void addFieldErrorMessage(String code, String propertyName, Object[] args)
	{
		Message msg = new Message(code, Message.MessageSeverity.Error, Message.MessageLevel.Field, args);
		msg.getMessageInfo().setRelatedPropertyName(propertyName);
		this.addMessage(msg);
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
	 * Adds the message.
	 *
	 * @param msgInfo the msg info
	 */
	public void addMessage(MessageInfo msgInfo)
	{
		this.addMessage(new Message(msgInfo));
	}

	/**
	 * Adds the messages.
	 *
	 * @param list the list
	 */
	public void addMessages(List<MessageInfo> list)
	{
		for (MessageInfo mi : list)
		{
			this.addMessage(mi);
		}
	}

	/**
	 * Merge.
	 *
	 * @param response the response
	 */
	public void merge(Response response)
	{
		getMessageList().addAll(response.getMessageList());

		if (isOperationSuccess())
		{
			setOperationSuccess(response.isOperationSuccess());
		}
	}
}
