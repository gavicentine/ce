/*
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved.
 */
package br.com.ce.common.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum PersistanceActionEnum.
 */
public enum PersistanceActionEnum
{

	/** The none. */
	NONE,

	/** The insert. */
	INSERT,

	/** The insert pessoa. */
	INSERT_PESSOA,

	/** The insert usuario. */
	INSERT_USUARIO,

	/** The update. */
	UPDATE,

	/** The update usuario senha. */
	UPDATE_USUARIO_SENHA,

	/** The delete. */
	DELETE,

	/** The select. */
	SELECT,

	/** The select by id. */
	SELECT_BY_ID,

	/** The select by name. */
	SELECT_BY_NAME;

	/**
	 * Gets the default name.
	 *
	 * @return the default name
	 */
	public static String getDefaultName()
	{
		return PersistanceActionEnum.class.getSimpleName();
	}
}
