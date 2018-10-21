/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import br.com.ce.common.model.IStringEnum;


// TODO: Auto-generated Javadoc
/**
 * The Enum UsuarioTipoEnum.
 */
public enum UsuarioTipoEnum implements IStringEnum
{

	/** The interno. */
	INTERNO("I"),

	/** The externo. */
	EXTERNO("E");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new usuario tipo enum.
	 *
	 * @param valor the valor
	 */
	private UsuarioTipoEnum(String valor)
	{
		value = valor;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ce.common.model.IStringEnum#getValue()
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the usuario tipo enum
	 */
	public static UsuarioTipoEnum enumForValue(String value)
	{
		for (UsuarioTipoEnum e : values())
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

		for (UsuarioTipoEnum i : UsuarioTipoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
