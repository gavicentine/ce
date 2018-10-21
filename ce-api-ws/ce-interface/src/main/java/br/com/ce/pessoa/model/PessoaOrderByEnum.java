/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.pessoa.model;

import br.com.ce.common.model.IStringEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum PessoaOrderByEnum.
 */
public enum PessoaOrderByEnum implements IStringEnum
{

	/** The codigo. */
	CODIGO("pessoa_num"),

	/** The nome. */
	NOME("nm_pessoa");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new pessoa order by enum.
	 *
	 * @param valor the valor
	 */
	private PessoaOrderByEnum(String valor)
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
	 * @return the pessoa order by enum
	 */
	public static PessoaOrderByEnum enumForValue(String value)
	{
		for (PessoaOrderByEnum e : values())
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

		for (PessoaOrderByEnum i : PessoaOrderByEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
