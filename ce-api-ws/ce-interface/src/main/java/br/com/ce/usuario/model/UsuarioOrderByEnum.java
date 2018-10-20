/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import br.com.ce.common.model.IStringEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum UsuarioOrderByEnum.
 */
public enum UsuarioOrderByEnum implements IStringEnum
{

	/** The login. */
	LOGIN("u.nm_login"),

	/** The nome. */
	NOME("p.nm_pessoa");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new usuario order by enum.
	 *
	 * @param valor the valor
	 */
	private UsuarioOrderByEnum(String valor)
	{
		value = valor;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.IStringEnum#getValue()
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the usuario order by enum
	 */
	public static UsuarioOrderByEnum enumForValue(String value)
	{
		for (UsuarioOrderByEnum e : values())
		{
			if (e.getValue().equals(value))
			{
				return e;
			}
		}

		return null;
	}

	/**
	 * Gets the valid values.
	 *
	 * @return the valid values
	 */
	public static String getValidValues()
	{
		String comma = "";
		StringBuilder enumValue = new StringBuilder();

		for (UsuarioOrderByEnum i : UsuarioOrderByEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
