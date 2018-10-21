/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ce.common.model.Message;
import br.com.ce.common.model.MessageInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationContext.
 */
public class ValidationContext
{

	/** The Constant CONTEXT_INDICATOR_SIMPLE_NAME. */
	private static final String CONTEXT_INDICATOR_SIMPLE_NAME = ValidationContextIndicator.class.getSimpleName();

	/** The objects to be validated. */
	private Map<String, Object> objectsToBeValidated = new HashMap<String, Object>();

	/** The validation arguments. */
	private Map<String, Object> validationArguments = new HashMap<String, Object>();

	/** The messages. */
	private List<MessageInfo> messages = new ArrayList<MessageInfo>();

	/** The stop processing. */
	private boolean stopProcessing;

	/**
	 * Instantiates a new validation context.
	 */
	public ValidationContext()
	{
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param newObjectsToBeValidated the new objects to be validated
	 * @param newValidationArguments the new validation arguments
	 * @param newMessages the new messages
	 */
	public ValidationContext(Map<String, Object> newObjectsToBeValidated, Map<String, Object> newValidationArguments,
			List<MessageInfo> newMessages)
	{
		setObjectsToBeValidated(newObjectsToBeValidated);
		setValidationArguments(newValidationArguments);
		setMessages(newMessages);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param newMessages the new messages
	 */
	public ValidationContext(List<MessageInfo> newMessages)
	{
		setMessages(newMessages);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param newObjectsToBeValidated the new objects to be validated
	 * @param newMessages the new messages
	 */
	public ValidationContext(Map<String, Object> newObjectsToBeValidated, List<MessageInfo> newMessages)
	{
		setObjectsToBeValidated(newObjectsToBeValidated);
		setMessages(newMessages);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @param objectToBeValidated the object to be validated
	 */
	public ValidationContext(String objectToBeValidatedName, Object objectToBeValidated)
	{
		getObjectsToBeValidated().put(objectToBeValidatedName, objectToBeValidated);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @param objectToBeValidated the object to be validated
	 * @param validationContextIndicator the validation context indicator
	 */
	public ValidationContext(String objectToBeValidatedName, Object objectToBeValidated,
			ValidationContextIndicator validationContextIndicator)
	{
		getObjectsToBeValidated().put(objectToBeValidatedName, objectToBeValidated);
		getValidationArguments().put(CONTEXT_INDICATOR_SIMPLE_NAME, validationContextIndicator);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @param objectToBeValidated the object to be validated
	 * @param validationArgumentName the validation argument name
	 * @param validationArgument the validation argument
	 */
	public ValidationContext(String objectToBeValidatedName, Object objectToBeValidated,
			String validationArgumentName, Object validationArgument)
	{
		getObjectsToBeValidated().put(objectToBeValidatedName, objectToBeValidated);
		getValidationArguments().put(validationArgumentName, validationArgument);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @param objectToBeValidated the object to be validated
	 * @param validationArgumentName the validation argument name
	 * @param validationArgument the validation argument
	 * @param validationContextIndicator the validation context indicator
	 */
	public ValidationContext(String objectToBeValidatedName, Object objectToBeValidated,
			String validationArgumentName, Object validationArgument,
			ValidationContextIndicator validationContextIndicator)
	{
		getObjectsToBeValidated().put(objectToBeValidatedName, objectToBeValidated);
		getValidationArguments().put(validationArgumentName, validationArgument);
		putValidationContextIndicator(validationContextIndicator);
	}

	/**
	 * Instantiates a new validation context.
	 *
	 * @param validationContextIndicator the validation context indicator
	 */
	public ValidationContext(ValidationContextIndicator validationContextIndicator)
	{
		putValidationContextIndicator(validationContextIndicator);
	}

	/**
	 * Gets the object to be validated.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @return the object to be validated
	 */
	public Object getObjectToBeValidated(String objectToBeValidatedName)
	{
		return getObjectsToBeValidated().get(objectToBeValidatedName);
	}

	/**
	 * Checks for object to be validated.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @return true, if successful
	 */
	public boolean hasObjectToBeValidated(String objectToBeValidatedName)
	{
		return getObjectsToBeValidated().containsKey(objectToBeValidatedName);
	}

	/**
	 * Put object to be validated.
	 *
	 * @param objectToBeValidatedName the object to be validated name
	 * @param objectToBeValidated the object to be validated
	 */
	public void putObjectToBeValidated(String objectToBeValidatedName, Object objectToBeValidated)
	{
		getObjectsToBeValidated().put(objectToBeValidatedName, objectToBeValidated);
	}

	/**
	 * Gets the validation context indicator.
	 *
	 * @return the validation context indicator
	 */
	public ValidationContextIndicator getValidationContextIndicator()
	{
		if (getValidationArguments().containsKey(CONTEXT_INDICATOR_SIMPLE_NAME))
		{
			return (ValidationContextIndicator)getValidationArguments().get(CONTEXT_INDICATOR_SIMPLE_NAME);
		}

		return null;
	}

	/**
	 * Put validation context indicator.
	 *
	 * @param validationContextIndicator the validation context indicator
	 */
	public void putValidationContextIndicator(ValidationContextIndicator validationContextIndicator)
	{
		getValidationArguments().put(CONTEXT_INDICATOR_SIMPLE_NAME, validationContextIndicator);
	}

	/**
	 * Adds the object error message.
	 *
	 * @param code the code
	 * @return the message info
	 */
	public MessageInfo addObjectErrorMessage(String code)
	{
		return this.addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Object, null);
	}

	/**
	 * Adds the object error message.
	 *
	 * @param code the code
	 * @param args the args
	 * @return the message info
	 */
	public MessageInfo addObjectErrorMessage(String code, Object[] args)
	{
		return addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Object, args);
	}

	/**
	 * Adds the field error message.
	 *
	 * @param code the code
	 * @return the message info
	 */
	public MessageInfo addFieldErrorMessage(String code)
	{
		return addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Field, null);
	}

	/**
	 * Adds the field error message.
	 *
	 * @param code the code
	 * @param args the args
	 * @return the message info
	 */
	public MessageInfo addFieldErrorMessage(String code, Object[] args)
	{
		return this.addMessage(code, Message.MessageSeverity.Error, Message.MessageLevel.Field, args);
	}

	/**
	 * Adds the message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param level the level
	 * @param args the args
	 * @return the message info
	 */
	public MessageInfo addMessage(String code, Message.MessageSeverity severity, Message.MessageLevel level,
			Object[] args)
	{
		MessageInfo messageInfo = new MessageInfo(code, severity, level, args);
		addMessage(messageInfo);
		return messageInfo;
	}

	/**
	 * Adds the message.
	 *
	 * @param messageInfo the message info
	 */
	public void addMessage(MessageInfo messageInfo)
	{
		getMessages().add(messageInfo);
	}

	/**
	 * Sets the objects to be validated.
	 *
	 * @param objectsToBeValidated the objects to be validated
	 */
	protected void setObjectsToBeValidated(Map<String, Object> objectsToBeValidated)
	{
		if (objectsToBeValidated != null)
		{
			this.objectsToBeValidated = objectsToBeValidated;
		}
	}

	/**
	 * Gets the objects to be validated.
	 *
	 * @return the objects to be validated
	 */
	public Map<String, Object> getObjectsToBeValidated()
	{
		return objectsToBeValidated;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	protected void setMessages(List<MessageInfo> messages)
	{
		if (messages != null)
		{
			this.messages = messages;
		}
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<MessageInfo> getMessages()
	{
		return messages;
	}

	/**
	 * Sets the validation arguments.
	 *
	 * @param validationArguments the validation arguments
	 */
	protected void setValidationArguments(Map<String, Object> validationArguments)
	{
		if (validationArguments != null)
		{
			this.validationArguments = validationArguments;
		}
	}

	/**
	 * Gets the validation arguments.
	 *
	 * @return the validation arguments
	 */
	public Map<String, Object> getValidationArguments()
	{
		return validationArguments;
	}

	/**
	 * Sets the stop processing.
	 *
	 * @param stopProcessing the new stop processing
	 */
	public void setStopProcessing(boolean stopProcessing)
	{
		this.stopProcessing = stopProcessing;
	}

	/**
	 * Checks if is stop processing.
	 *
	 * @return true, if is stop processing
	 */
	public boolean isStopProcessing()
	{
		return stopProcessing;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ValidationContext [getObjectsToBeValidated():");
		builder.append(getObjectsToBeValidated());
		builder.append(", getMessages():");
		builder.append(getMessages());
		builder.append(", getValidationArguments():");
		builder.append(getValidationArguments());
		builder.append(", isStopProcessing():");
		builder.append(isStopProcessing());
		builder.append("]");
		return builder.toString();
	}
}
