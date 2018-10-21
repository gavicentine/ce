/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.pessoa.model;

import br.com.ce.common.model.IStringEnum;


// TODO: Auto-generated Javadoc
/**
 * The Enum PessoaSituacaoEnum.
 */
public enum PessoaSituacaoEnum implements IStringEnum
{

	/** The ativo. */
	ATIVO("A"),

	/** The inativo. */
	INATIVO("I"),

	/** The todas. */
	TODAS("T");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new pessoa situacao enum.
	 *
	 * @param valor the valor
	 */
	private PessoaSituacaoEnum(String valor)
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
	 * @return the pessoa situacao enum
	 */
	public static PessoaSituacaoEnum enumForValue(String value)
	{
		for (PessoaSituacaoEnum e : values())
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

		for (PessoaSituacaoEnum i : PessoaSituacaoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
