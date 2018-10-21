/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import br.com.ce.common.model.IStringEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum PerfilAcessoOrderByEnum.
 */
public enum PerfilAcessoOrderByEnum implements IStringEnum
{

	/** The codigo. */
	CODIGO("pa.perfil_num"),

	/** The nome. */
	NOME("pa.nm_perfil");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new perfil acesso order by enum.
	 *
	 * @param valor the valor
	 */
	private PerfilAcessoOrderByEnum(String valor)
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
	 * @return the perfil acesso order by enum
	 */
	public static PerfilAcessoOrderByEnum enumForValue(String value)
	{
		for (PerfilAcessoOrderByEnum e : values())
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

		for (PerfilAcessoOrderByEnum i : PerfilAcessoOrderByEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
