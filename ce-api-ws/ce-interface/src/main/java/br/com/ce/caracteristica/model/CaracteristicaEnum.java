/*
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved.
 */
package br.com.ce.caracteristica.model;

import br.com.ce.common.model.IIntegerEnum;

// TODO: Auto-generated Javadoc
/**
 * The Enum CaracteristicaEnum.
 */
public enum CaracteristicaEnum implements IIntegerEnum
{

	/** The apenas consulta. */
	APENAS_CONSULTA(1, CaracteristicaTipoEnum.USUARIO),

	/** The restringir processos advogado. */
	RESTRINGIR_PROCESSOS_ADVOGADO(2, CaracteristicaTipoEnum.USUARIO),

	/** The advogado funcionario. */
	ADVOGADO_FUNCIONARIO(3, CaracteristicaTipoEnum.ADVOGADO),

	/** The restringir agenda. */
	RESTRINGIR_AGENDA(4, CaracteristicaTipoEnum.USUARIO),

	/** The exclui processos. */
	EXCLUI_PROCESSOS(5, CaracteristicaTipoEnum.USUARIO);

	/** The value. */
	private Integer value;

	/** The caracteristica tipo. */
	private CaracteristicaTipoEnum caracteristicaTipo;

	/**
	 * Instantiates a new caracteristica enum.
	 *
	 * @param valor the valor
	 * @param caracteristicaTipo the caracteristica tipo
	 */
	private CaracteristicaEnum(Integer valor, CaracteristicaTipoEnum caracteristicaTipo)
	{
		this.value = valor;
		this.caracteristicaTipo = caracteristicaTipo;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.IStringEnum#getValue()
	 */
	public Integer getValue()
	{
		return this.value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the caracteristica enum
	 */
	public static CaracteristicaEnum enumForValue(Integer value)
	{
		for (CaracteristicaEnum e : values())
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

		for (CaracteristicaEnum i : CaracteristicaEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}

	/**
	 * Gets the caracteristica tipo.
	 *
	 * @return the caracteristica tipo
	 */
	public CaracteristicaTipoEnum getCaracteristicaTipo()
	{
		return this.caracteristicaTipo;
	}

}
