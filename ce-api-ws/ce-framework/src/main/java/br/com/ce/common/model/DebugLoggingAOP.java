/* 
 * 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DebugLoggingAOP.
 */
public class DebugLoggingAOP implements MethodInterceptor
{

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(DebugLoggingAOP.class);

	/*
	 * (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation methodInvocation) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		LOG.info("Inicio metodo: " + methodInvocation.getMethod().getDeclaringClass() + "::"
				+ methodInvocation.getMethod().getName());
		if (LOG.isDebugEnabled())
		{
			LOG.debug("Params metodo: " + methodInvocation.getArguments().length);

			for (Object object : methodInvocation.getArguments())
			{
				LOG.debug(StringUtil.createToString(object));
			}
		}
		Object returnValue = new Object();
		try
		{
			returnValue = methodInvocation.proceed();
		}
		finally
		{
			LOG.info("Fim metodo: " + methodInvocation.getMethod().getDeclaringClass() + "::"
					+ methodInvocation.getMethod().getName() + "::" + (System.currentTimeMillis() - startTime)
					+ " msecs.");

			if (LOG.isDebugEnabled())
			{
				LOG.debug("Retorno metodo: " + StringUtil.createToString(returnValue));
			}
		}
		return returnValue;
	}
}
