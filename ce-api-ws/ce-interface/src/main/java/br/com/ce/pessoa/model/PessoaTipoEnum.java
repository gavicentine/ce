/*
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved.
 */
package br.com.ce.pessoa.model;

import br.com.ce.common.model.IIntegerEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum PessoaTipoEnum.
 */
public enum PessoaTipoEnum implements IIntegerEnum
{

	/** The empresa. */
	EMPRESA(1),

	/** The cliente. */
	CLIENTE(2),

	/** The funcionario. */
	FUNCIONARIO(3),

	/** The advogado. */
	ADVOGADO(4),

	/** The advogado. */
	EMPRESA_FATURAMENTO(5);

	/** The value. */
	private Integer value;

	/**
	 * Instantiates a new pessoa tipo enum.
	 *
	 * @param valor the valor
	 */
	private PessoaTipoEnum(Integer valor)
	{
		value = valor;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.IStringEnum#getValue()
	 */
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Integer getValue()
	{
		return value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the pessoa tipo enum
	 */
	public static PessoaTipoEnum enumForValue(Integer value)
	{
		for (PessoaTipoEnum e : values())
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

		for (PessoaTipoEnum i : PessoaTipoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
