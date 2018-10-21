/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.base.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import br.com.ce.common.model.Message;
import br.com.ce.common.model.MessageInfo;
import br.com.ce.common.model.response.InquiryResponse;
import br.com.ce.common.model.response.InternalResponse;
import br.com.ce.common.model.response.InternalResponse.Status;
import br.com.ce.common.model.response.InternalResultsResponse;
import br.com.ce.common.model.response.Response;
import br.com.ce.common.validation.ValidationUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceUtil.
 */
public final class InterfaceUtil
{

	/** The Constant STR_HASH. */
	private static final String STR_HASH = "\n### ";

	/**
	 * Handle exception.
	 *
	 * @param log the log
	 * @param resp the resp
	 * @param ex the ex
	 */
	public static void handleException(Logger log, Response resp, Exception ex)
	{
		Message msg =
				Message.internalMessage("911", Message.MessageSeverity.Error,
						"An exception has occured, see the trace-info for more information in addition this exception will be logged."
								+ ex.getMessage());
		msg.getMessageInfo().setTraceInfo(ex.toString());
		resp.addMessage(msg);
		resp.setOperationSuccess(false);
		log.error(msg.toString(), ex);
	}

	/**
	 * Handle exception.
	 *
	 * @param log the log
	 * @param resp the resp
	 * @param ex the ex
	 * @param msgCode the msg code
	 * @param args the args
	 */
	public static void handleException(Logger log, Response resp, Exception ex, String msgCode, Object[] args)
	{
		Message msg = new Message(msgCode, Message.MessageSeverity.Fatal, Message.MessageLevel.Object, args);
		msg.getMessageInfo().setTraceInfo(ex.toString());
		resp.addMessage(msg);
		resp.setOperationSuccess(false);
		log.error(msg.toString(), ex);
	}

	/**
	 * Handle exception.
	 *
	 * @param log the log
	 * @param resp the resp
	 * @param ex the ex
	 * @param msgCode the msg code
	 */
	public static void handleException(Logger log, Response resp, Exception ex, String msgCode)
	{
		Message msg = new Message(msgCode, Message.MessageSeverity.Fatal, Message.MessageLevel.Object);
		msg.getMessageInfo().setTraceInfo(ex.toString());
		resp.addMessage(msg);
		resp.setOperationSuccess(false);
		log.error(msg.toString(), ex);
	}

	/**
	 * Handle exception.
	 *
	 * @param log the log
	 * @param resp the resp
	 * @param ex the ex
	 * @param msg the msg
	 */
	public static void handleException(Logger log, Response resp, Exception ex, Message msg)
	{
		msg.getMessageInfo().setTraceInfo(ex.toString());
		resp.addMessage(msg);
		resp.setOperationSuccess(false);
		log.error(msg.toString(), ex);
	}

	/**
	 * Handle operation status and messages.
	 *
	 * @param response the response
	 * @param internalResponse the internal response
	 * @param copyOver the copy over
	 * @return true, if successful
	 */
	public static boolean handleOperationStatusAndMessages(Response response, InternalResponse internalResponse,
			boolean copyOver)
	{
		return handleOperationStatusAndMessages(response, internalResponse, null, copyOver);
	}

	/**
	 * Handle operation status and messages.
	 *
	 * @param response the response
	 * @param internalResponse the internal response
	 * @param message the message
	 * @return true, if successful
	 */
	public static boolean handleOperationStatusAndMessages(Response response, InternalResponse internalResponse,
			String message)
	{
		List<MessageInfo> validationMessages = new ArrayList<MessageInfo>(1);
		if (internalResponse.getStatus() != Status.OperationSuccess
				&& ValidationUtil.isNullOrEmpty(internalResponse.getMessageInfoList()))
		{
			validationMessages
					.add(new MessageInfo(message, Message.MessageSeverity.Error, Message.MessageLevel.Object));
		}
		return handleOperationStatusAndMessages(response, internalResponse, validationMessages, false);
	}

	/**
	 * Handle operation status and messages.
	 *
	 * @param response the response
	 * @param internalResponse the internal response
	 * @param validationMessages the validation messages
	 * @param copyOver the copy over
	 * @return true, if successful
	 */
	public static boolean handleOperationStatusAndMessages(Response response, InternalResponse internalResponse,
			List<MessageInfo> validationMessages, boolean copyOver)
	{
		// If there are message then validation failed...
		if (validationMessages != null && !validationMessages.isEmpty())
		{
			response.setOperationSuccess(false);
			response.addMessages(validationMessages);
			return response.isOperationSuccess();
		}

		// If there is a response then set the operation success using it and copy of messages.
		if (internalResponse != null)
		{
			// set the operation success based on mapping found in Response type.
			response.setOperationSuccess(internalResponse.getStatus());
			response.addMessages(internalResponse.getMessageInfoList());

			// If operation success then see if we can copy-over the results.
			if (response.isOperationSuccess() && copyOver)
			{
				if (internalResponse instanceof InternalResultsResponse<?> &&
						response instanceof InquiryResponse)
				{
					((InquiryResponse)response).addResults(((InternalResultsResponse<?>)internalResponse)
							.getResultsList());
					((InquiryResponse)response).setResultsSetInfo(((InternalResultsResponse<?>)internalResponse)
							.getResultsSetInfo());
				}
			}
		}

		return response.isOperationSuccess();
	}

	/**
	 * To internal results response.
	 *
	 * @param <T> the generic type
	 * @param internalResponse the internal response
	 * @return the internal results response
	 */
	public static <T> InternalResultsResponse<T> toInternalResultsResponse(InternalResponse internalResponse)
	{
		InternalResultsResponse<T> response = new InternalResultsResponse<T>();
		response.setStatus(internalResponse.getStatus());
		response.addMessages(internalResponse.getMessageInfoList());
		return response;
	}

	/**
	 * Prints the log debug enabled.
	 *
	 * @param log the log
	 * @param message the message
	 */
	public static void printLogDebugEnabled(Logger log, String message)
	{
		if (log.isDebugEnabled())
		{
			log.debug(STR_HASH + message);
		}
	}

}
