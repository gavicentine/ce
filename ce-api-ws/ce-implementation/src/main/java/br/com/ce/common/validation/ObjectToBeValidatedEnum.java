/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.validation;

import br.com.ce.common.model.IStringEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum ObjectToBeValidatedEnum.
 */
public enum ObjectToBeValidatedEnum implements IStringEnum
{

	/** The data inicial. */
	DATA_INICIAL("dataInicial"),

	/** The data final. */
	DATA_FINAL("dataFinal");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new object to be validated enum.
	 *
	 * @param valor the valor
	 */
	private ObjectToBeValidatedEnum(String valor)
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
	 * @return the object to be validated enum
	 */
	public static ObjectToBeValidatedEnum enumForValue(String value)
	{
		for (ObjectToBeValidatedEnum e : values())
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

		for (ObjectToBeValidatedEnum i : ObjectToBeValidatedEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
