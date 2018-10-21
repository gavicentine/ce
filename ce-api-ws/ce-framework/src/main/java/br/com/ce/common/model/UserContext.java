/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

// TODO: Auto-generated Javadoc
/**
 * The Class UserContext.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class UserContext extends GenericModel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The login. */
	private String login;

	/** The locale string. */
	private String localeString;

	/**
	 * Instantiates a new user context.
	 */
	public UserContext()
	{
	}

	/**
	 * Instantiates a new user context.
	 *
	 * @param strLogin the str login
	 */
	public UserContext(String strLogin)
	{
		this();
		setLogin(strLogin);
	}

	/**
	 * Gets the locale string.
	 *
	 * @return the locale string
	 */
	public String getLocaleString()
	{
		return localeString;
	}

	/**
	 * Sets the locale string.
	 *
	 * @param value the new locale string
	 */
	public void setLocaleString(String value)
	{
		localeString = value;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin()
	{
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ce.common.model.GenericModel#toString()
	 */
	@Override
	public String toString()
	{
		return "UserContext [getLocaleString()=" + getLocaleString() + ", getLogin()=" + getLogin() + ", toString()="
				+ super.toString() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (login == null ? 0 : login.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		UserContext other = (UserContext)obj;
		if (login == null)
		{
			if (other.login != null)
			{
				return false;
			}
		}
		else if (!login.equals(other.login))
		{
			return false;
		}
		return true;
	}

}
