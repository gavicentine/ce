/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import br.com.ce.common.model.IStringEnum;


// TODO: Auto-generated Javadoc
/**
 * The Enum UsuarioSituacaoEnum.
 */
public enum UsuarioSituacaoEnum implements IStringEnum
{

	/** The ativo. */
	ATIVO("A"),

	/** The inativo. */
	INATIVO("I");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new usuario situacao enum.
	 *
	 * @param valor the valor
	 */
	private UsuarioSituacaoEnum(String valor)
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
	 * @return the usuario situacao enum
	 */
	public static UsuarioSituacaoEnum enumForValue(String value)
	{
		for (UsuarioSituacaoEnum e : values())
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

		for (UsuarioSituacaoEnum i : UsuarioSituacaoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
