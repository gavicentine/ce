/* 
 * 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// TODO: Auto-generated Javadoc
/**
 * The Class AppContext.
 */
public class AppContext implements ApplicationContextAware
{

	/** The app context. */
	private static ApplicationContext APP_CONTEXT;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException
	{
		APP_CONTEXT = arg0;
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	public static ApplicationContext getApplicationContext()
	{
		return APP_CONTEXT;
	}

	/**
	 * Gets the bean.
	 *
	 * @param beanName the bean name
	 * @return the bean
	 */
	public static Object getBean(String beanName)
	{
		if (beanName == null || beanName.trim().length() == 0)
		{
			return null;
		}
		else
		{
			return APP_CONTEXT.getBean(beanName);
		}
	}
}