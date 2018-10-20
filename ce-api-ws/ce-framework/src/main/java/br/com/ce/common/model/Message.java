/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message
{
	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(Message.class);

	/** The not found. */
	private static String NOT_FOUND =
			"Message Error - Message code[{0}] was not found. Make sure you have configured the Spring "
					+ "\"messageSource\" bean and included the appropriate property files in the classpath";

	/** The not found message format. */
	private static MessageFormat notFoundMessageFormat = new MessageFormat(NOT_FOUND);

	/** The msg info. */
	private MessageInfo msgInfo = new MessageInfo();

	/** The text. */
	private String text;

	/** The text resolved. */
	@XmlTransient
	private boolean textResolved = false;

	/**
	 * The Enum MessageLevel.
	 */
	public static enum MessageLevel
	{
		
		/** The None. */
		None,

		/** The Object. */
		Object,

		/** The Field. */
		Field,

		/** The Field validation. */
		FieldValidation,

		/** The Other. */
		Other
	};

	/**
	 * The Enum MessageSeverity.
	 */
	public static enum MessageSeverity
	{
		
		/** The None. */
		None,

		/** The Info. */
		Info,

		/** The Warning. */
		Warning,

		/** The Error. */
		Error,

		/** The Fatal. */
		Fatal
	}

	/**
	 * Instantiates a new message.
	 */
	private Message()
	{
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param level the level
	 * @param args the args
	 */
	public Message(String code, Message.MessageSeverity severity, Message.MessageLevel level, Object... args)
	{
		msgInfo.setSeverity(severity);
		msgInfo.setLevel(level);
		msgInfo.setArguments(args);
		msgInfo.setCode(code);

		resolveMessageCode();
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param level the level
	 */
	public Message(String code, Message.MessageSeverity severity, Message.MessageLevel level)
	{
		msgInfo.setSeverity(severity);
		msgInfo.setLevel(level);
		msgInfo.setCode(code);

		resolveMessageCode();
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param msgInfo the msg info
	 */
	public Message(MessageInfo msgInfo)
	{
		setMessageInfo(msgInfo);
	}

	/**
	 * Internal message.
	 *
	 * @param code the code
	 * @param severity the severity
	 * @param text the text
	 * @return the message
	 */
	public static Message internalMessage(String code, Message.MessageSeverity severity, String text)
	{
		// Don't new-up the Message using the 3 parameter constructor since it will try
		// to set the code which won't work since this is an internal type message.
		// Instead set the values manually.
		// Message msg = new Message(code, severity, MessageLevel.Object);
		Message msg = new Message();

		msg.msgInfo = MessageInfo.internalMessage(code, severity, text);
		msg.textResolved = true;
		msg.text = "This is an internal message and should not be passed through to the consumer/client";

		return msg;
	}

	/**
	 * Sets the message info.
	 *
	 * @param info the new message info
	 */
	public void setMessageInfo(MessageInfo info)
	{
		msgInfo = info;
		resolveMessageCode();
	}

	/**
	 * Gets the message info.
	 *
	 * @return the message info
	 */
	public MessageInfo getMessageInfo()
	{
		return msgInfo;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText()
	{
		if (msgInfo.isInternalMsg())
		{
			return msgInfo.getInternalMsgText();
		}

		if (textResolved == false)
		{
			resolveMessageCode();
		}

		return text;
	}

	/**
	 * To xml string.
	 *
	 * @return the string
	 */
	public String toXMLString()
	{
		JAXBContext context;
		StringWriter sw = new StringWriter();
		try
		{
			context = JAXBContext.newInstance(Message.class);
			Marshaller m = context.createMarshaller();
			m.marshal(this, sw);
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		return sw.toString();
	}

	/**
	 * Resolve message code.
	 */
	private void resolveMessageCode()
	{
		if (getMessageInfo().isInternalMsg())
		{
			return;
		}

		if (msgInfo.getCode() == null)
		{
			text = "Message code is null.";
		}
		else
		{
			// QATMessageUtil will return null if messageCode not found
			String messageText = MessageUtil.getMessage(msgInfo.getCode(), msgInfo.getArguments());

			if (messageText == null)
			{
				messageText = notFoundMessageFormat.format(new Object[] {msgInfo.getCode()});
				LOG.warn(messageText);
			}

			text = messageText;
			textResolved = true;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sb.append("Message severity[" + getMessageInfo().getSeverity() + "] date["
				+ sdf.format(getMessageInfo().getCreateDate().getTime()) + "] ");
		sb.append("messageCode[" + getMessageInfo().getCode() + "] level[" + getMessageInfo().getLevel()
				+ "] isInternal[" + getMessageInfo().isInternalMsg() + "] text=[" + getText() + "]");
		if (getMessageInfo().getTraceInfo() != null)
		{
			sb.append("\ntrace info[" + getMessageInfo().getTraceInfo() + "]");
		}

		return sb.toString();
	}

}
