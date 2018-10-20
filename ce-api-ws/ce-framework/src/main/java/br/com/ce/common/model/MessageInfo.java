/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.ce.common.model.Message.MessageLevel;
import br.com.ce.common.model.Message.MessageSeverity;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageInfo.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageInfo
{
	
	/** The severity. */
	private MessageSeverity severity = MessageSeverity.None;

	/** The level. */
	private MessageLevel level = MessageLevel.None;

	/** The code. */
	private String code;

	/** The related property name. */
	private String relatedPropertyName;

	/** The create date. */
	private final Date createDate = Calendar.getInstance().getTime();

	/** The arguments. */
	@XmlTransient
	private Object[] arguments;

	/** The internal msg. */
	@XmlTransient
	private boolean internalMsg;

	/** The trace info. */
	private String traceInfo;

	/** The internal text. */
	@XmlTransient
	private String internalText;

	/**
	 * Instantiates a new message info.
	 */
	public MessageInfo()
	{
	}

	/**
	 * Instantiates a new message info.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param level the level
	 * @param args the args
	 */
	public MessageInfo(String code, Message.MessageSeverity severity, Message.MessageLevel level, Object... args)
	{
		this.severity = severity;
		this.level = level;
		arguments = args;
		this.code = code;
	}

	/**
	 * Instantiates a new message info.
	 *
	 * @param newCode the new code
	 * @param newSeverity the new severity
	 * @param newLevel the new level
	 */
	public MessageInfo(String newCode, Message.MessageSeverity newSeverity, Message.MessageLevel newLevel)
	{
		severity = newSeverity;
		level = newLevel;
		code = newCode;
	}

	/**
	 * Internal message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param text the text
	 * @return the message info
	 */
	public static MessageInfo internalMessage(String code, Message.MessageSeverity severity, String text)
	{
		MessageInfo mi = new MessageInfo();
		mi.code = code;
		mi.severity = severity;
		mi.internalText = text;
		mi.internalMsg = true;

		return mi;
	}

	/**
	 * Creates the object error.
	 *
	 * @param code the code
	 * @param args the args
	 * @return the message info
	 */
	public static MessageInfo createObjectError(String code, Object... args)
	{
		return new MessageInfo(code, Message.MessageSeverity.Error, Message.MessageLevel.Object, args);
	}

	/**
	 * Creates the field validation error.
	 *
	 * @param code the code
	 * @param args the args
	 * @return the message info
	 */
	public static MessageInfo createFieldValidationError(String code, Object... args)
	{
		return new MessageInfo(code, Message.MessageSeverity.Error, Message.MessageLevel.FieldValidation, args);
	}

	/**
	 * Gets the severity.
	 *
	 * @return the severity
	 */
	public MessageSeverity getSeverity()
	{
		return severity;
	}

	/**
	 * Sets the severity.
	 *
	 * @param severity the new severity
	 */
	public void setSeverity(MessageSeverity severity)
	{
		this.severity = severity;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public MessageLevel getLevel()
	{
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(MessageLevel level)
	{
		this.level = level;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	protected void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * Gets the related property name.
	 *
	 * @return the related property name
	 */
	public String getRelatedPropertyName()
	{
		return relatedPropertyName;
	}

	/**
	 * Sets the related property name.
	 *
	 * @param relatedPropertyName the new related property name
	 */
	public void setRelatedPropertyName(String relatedPropertyName)
	{
		this.relatedPropertyName = relatedPropertyName;
	}

	/**
	 * Gets the arguments.
	 *
	 * @return the arguments
	 */
	public Object[] getArguments()
	{
		return arguments;
	}

	/**
	 * Sets the arguments.
	 *
	 * @param arguments the new arguments
	 */
	public void setArguments(Object[] arguments)
	{
		this.arguments = arguments;
	}

	/**
	 * Checks if is internal msg.
	 *
	 * @return true, if is internal msg
	 */
	public boolean isInternalMsg()
	{
		return internalMsg;
	}

	/**
	 * Gets the internal msg text.
	 *
	 * @return the internal msg text
	 */
	protected String getInternalMsgText()
	{
		return internalText;
	}

	/**
	 * Gets the trace info.
	 *
	 * @return the trace info
	 */
	public String getTraceInfo()
	{
		return traceInfo;
	}

	/**
	 * Sets the trace info.
	 *
	 * @param traceInfo the new trace info
	 */
	public void setTraceInfo(String traceInfo)
	{
		this.traceInfo = traceInfo;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate()
	{
		return createDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("MessageInfo::Severity=[" + severity + "], Level=[" + level + "], code=[" + code
				+ "], create date=[" + createDate + "], "
				+ ", relatedPropertyName=" + relatedPropertyName + "]"
				+ "internal message=[" + internalMsg + "], trace info=["
				+ traceInfo + "]");
		if (internalMsg == true)
		{
			sb.append("internal message text=[" + internalText + "]");
		}

		return sb.toString();
	}
}
