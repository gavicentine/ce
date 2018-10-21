/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.pessoa.model;

import br.com.ce.common.model.IStringEnum;



// TODO: Auto-generated Javadoc
/**
 * The Enum PessoaSexoEnum.
 */
public enum PessoaSexoEnum implements IStringEnum
{

	/** The feminino. */
	FEMININO("F"),

	/** The mausculino. */
	MAUSCULINO("J");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new pessoa sexo enum.
	 *
	 * @param valor the valor
	 */
	private PessoaSexoEnum(String valor)
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
	 * @return the pessoa sexo enum
	 */
	public static PessoaSexoEnum enumForValue(String value)
	{
		for (PessoaSexoEnum e : values())
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

		for (PessoaSexoEnum i : PessoaSexoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
