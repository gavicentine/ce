/*
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved.
 */
package br.com.ce.caracteristica.model;

import br.com.ce.common.model.IStringEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum CaracteristicaTipoEnum.
 */
public enum CaracteristicaTipoEnum implements IStringEnum
{

	/** The usuario. */
	USUARIO("U"),

	/** The advogado. */
	ADVOGADO("A"),

	/** The cliente. */
	CLIENTE("C");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new caracteristica tipo enum.
	 *
	 * @param valor the valor
	 */
	private CaracteristicaTipoEnum(String valor)
	{
		this.value = valor;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ce.common.model.IStringEnum#getValue()
	 */
	public String getValue()
	{
		return this.value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the caracteristica tipo enum
	 */
	public static CaracteristicaTipoEnum enumForValue(String value)
	{
		for (CaracteristicaTipoEnum e : values())
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

		for (CaracteristicaTipoEnum i : CaracteristicaTipoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
