/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class StringUtil.
 */
public class StringUtil
{

	/**
	 * Creates the to string.
	 *
	 * @param object the object
	 * @return the string
	 */
	public static final String createToString(Object object)
	{
		String ret = null;
		try
		{
			ret = object.toString();
		}
		catch (Exception x)
		{
			try
			{
				ret = ToStringBuilder.reflectionToString(object);
			}
			catch (Exception x2)
			{
				ret = null;
			}
		}
		return ret;
	}
}
