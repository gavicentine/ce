/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum RecordStatusEnum.
 */
public enum RecordStatusEnum implements IStringEnum
{

	/** The none. */
	NONE("N"),

	/** The deleting. */
	DELETING("D"),

	/** The inserting. */
	INSERTING("I"),

	/** The updating. */
	UPDATING("U");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new record status enum.
	 *
	 * @param valor the valor
	 */
	private RecordStatusEnum(String valor)
	{
		value = valor;
	}

	/* (non-Javadoc)
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
	 * @return the record status enum
	 */
	public static RecordStatusEnum enumForValue(String value)
	{
		for (RecordStatusEnum e : values())
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

		for (RecordStatusEnum i : RecordStatusEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
