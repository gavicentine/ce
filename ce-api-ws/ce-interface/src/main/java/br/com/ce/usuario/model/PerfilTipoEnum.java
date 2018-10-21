/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import br.com.ce.common.model.IIntegerEnum;


// TODO: Auto-generated Javadoc
/**
 * The Enum PerfilTipoEnum.
 */
public enum PerfilTipoEnum implements IIntegerEnum
{

	/** The role admin. */
	ROLE_ADMIN(1),
	
	/** The role advogado. */
	ROLE_ADVOGADO(2),

	/** The role consulta. */
	ROLE_CONSULTA(3),
	
	/** The role cliente. */
	ROLE_CLIENTE(4),
		
	/** The ROL e_1. */
	ROLE_1(5),
	
	/** The ROL e_2. */
	ROLE_2(6),

	/** The ROL e_3. */
	ROLE_3(7),
	
	/** The ROL e_4. */
	ROLE_4(8),
	
	/** The ROL e_5. */
	ROLE_5(9),
	
	/** The ROL e_6. */
	ROLE_6(10),
	
	/** The ROL e_7. */
	ROLE_7(11),
	
	/** The ROL e_8. */
	ROLE_8(12),
	
	/** The ROL e_9. */
	ROLE_9(13),
	
	/** The ROL e_10. */
	ROLE_10(14);
	

	/** The value. */
	private Integer value;

	/**
	 * Instantiates a new perfil tipo enum.
	 *
	 * @param valor the valor
	 */
	private PerfilTipoEnum(Integer valor)
	{
		value = valor;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ce.common.model.IStringEnum#getValue()
	 */
	public Integer getValue()
	{
		return value;
	}

	/**
	 * Enum for value.
	 *
	 * @param value the value
	 * @return the perfil tipo enum
	 */
	public static PerfilTipoEnum enumForValue(Integer value)
	{
		for (PerfilTipoEnum e : values())
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

		for (PerfilTipoEnum i : PerfilTipoEnum.class.getEnumConstants())
		{
			enumValue.append(comma).append(i.getValue());
			comma = ", ";
		}

		return enumValue.toString();
	}
}
