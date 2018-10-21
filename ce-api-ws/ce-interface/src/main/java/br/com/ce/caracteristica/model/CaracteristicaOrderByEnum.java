/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.caracteristica.model;

import br.com.ce.common.model.IStringEnum;



// TODO: Auto-generated Javadoc
/**
 * The Enum CaracteristicaOrderByEnum.
 */
public enum CaracteristicaOrderByEnum implements IStringEnum
{

	/** The codigo. */
	CODIGO("c.caract_num"),

	/** The nome. */
	NOME("c.nm_caract");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new caracteristica order by enum.
	 *
	 * @param valor the valor
	 */
	private CaracteristicaOrderByEnum(String valor)
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
	 * @return the caracteristica order by enum
	 */
	public static CaracteristicaOrderByEnum enumForValue(String value)
	{
		for (CaracteristicaOrderByEnum e : values())
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

		for (CaracteristicaOrderByEnum i : CaracteristicaOrderByEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
