/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import java.util.List;
import java.util.Locale;

import br.com.ce.common.model.Message.MessageSeverity;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageUtil.
 */
public final class MessageUtil
{

	/**
	 * Gets the message.
	 *
	 * @param messageId the message id
	 * @return the message
	 */
	public static String getMessage(String messageId)
	{
		return MessageUtil.getMessage(messageId, null);
	}

	/**
	 * Gets the message.
	 *
	 * @param messageId the message id
	 * @param args the args
	 * @return the message
	 */
	public static String getMessage(String messageId, Object[] args)
	{
		return MessageUtil.getMessage(messageId, args, null);
	}

	/**
	 * Gets the message.
	 *
	 * @param messageId the message id
	 * @param args the args
	 * @param defaultMsgText the default msg text
	 * @return the message
	 */
	public static String getMessage(String messageId, Object[] args, String defaultMsgText)
	{
		return MessageUtil.getMessage(messageId, args, defaultMsgText, Locale.getDefault());
	}

	/**
	 * Gets the message.
	 *
	 * @param messageId the message id
	 * @param args the args
	 * @param defaultMsgText the default msg text
	 * @param locale the locale
	 * @return the message
	 */
	public static String getMessage(String messageId, Object[] args, String defaultMsgText, Locale locale)
	{
		return AppContext.getApplicationContext().getMessage(messageId, args, defaultMsgText, locale);
	}

	/**
	 * Checks for only info.
	 *
	 * @param messages the messages
	 * @return true, if successful
	 */
	public static boolean hasOnlyInfo(List<MessageInfo> messages)
	{
		for (MessageInfo msg : messages)
		{
			if (MessageSeverity.Info != msg.getSeverity())
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks for errors.
	 *
	 * @param messageList the message list
	 * @return true, if successful
	 */
	public static boolean hasErrors(List<MessageInfo> messageList)
	{
		return hasErrors(messageList, false, true);
	}

	/**
	 * Checks for errors.
	 *
	 * @param messageList the message list
	 * @param includeFatal the include fatal
	 * @return true, if successful
	 */
	public static boolean hasErrors(List<MessageInfo> messageList, boolean includeFatal)
	{
		return hasErrors(messageList, false, includeFatal);
	}

	/**
	 * Checks for errors.
	 *
	 * @param messageList the message list
	 * @param includeWarning the include warning
	 * @param includeFatal the include fatal
	 * @return true, if successful
	 */
	public static boolean hasErrors(List<MessageInfo> messageList, boolean includeWarning, boolean includeFatal)
	{
		if (messageList == null || messageList.size() == 0)
		{
			return false;
		}

		for (MessageInfo messageInfo : messageList)
		{
			if (messageInfo.getSeverity().equals(Message.MessageSeverity.Error))
			{
				return true;
			}

			if (includeWarning)
			{
				if (messageInfo.getSeverity().equals(Message.MessageSeverity.Warning))
				{
					return true;
				}
			}

			if (includeFatal)
			{
				if (messageInfo.getSeverity().equals(Message.MessageSeverity.Fatal))
				{
					return true;
				}
			}
		}

		return false;
	}
}
