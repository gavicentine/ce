/*
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved.
 */
package br.com.ce.common.model;

import br.com.ce.common.model.IStringEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum SimNaoEnum.
 */
public enum SimNaoEnum implements IStringEnum
{

	/** The sim. */
	SIM("S", "SIM"),

	/** The nao. */
	NAO("N", "N�O");

	/** The value. */
	private String value;

	/** The label. */
	private String label;

	/**
	 * Instantiates a new sim nao enum.
	 *
	 * @param valor the valor
	 * @param label the label
	 */
	private SimNaoEnum(String valorParam, String labelParam)
	{
		value = valorParam;
		label = labelParam;
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
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the sim nao enum
	 */
	public static SimNaoEnum enumForValue(String value)
	{
		for (SimNaoEnum e : values())
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

		for (SimNaoEnum i : SimNaoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
