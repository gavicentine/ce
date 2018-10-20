/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.meioComunicacao.model;

import br.com.ce.common.model.IIntegerEnum;



// TODO: Auto-generated Javadoc
/**
 * The Enum MeioComunicacaoTipoEnum.
 */
public enum MeioComunicacaoTipoEnum implements IIntegerEnum
{

	/** The telefone. */
	TELEFONE(1),

	/** The comercial. */
	COMERCIAL(2),

	/** The celular. */
	CELULAR(3),

	/** The email. */
	EMAIL(4);

	/** The value. */
	private Integer value;

	/**
	 * Instantiates a new meio comunicacao tipo enum.
	 *
	 * @param valor the valor
	 */
	private MeioComunicacaoTipoEnum(Integer valor)
	{
		value = valor;
	}

	/* (non-Javadoc)
	 * @see br.com.ezproc.common.model.IIntegerEnum#getValue()
	 */
	public Integer getValue()
	{
		return value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the meio comunicacao tipo enum
	 */
	public static MeioComunicacaoTipoEnum enumForValue(Integer value)
	{
		for (MeioComunicacaoTipoEnum e : values())
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

		for (MeioComunicacaoTipoEnum i : MeioComunicacaoTipoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
