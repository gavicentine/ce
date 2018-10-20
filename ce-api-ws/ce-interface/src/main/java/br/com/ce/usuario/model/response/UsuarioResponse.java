/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model.response;

import java.util.List;

import br.com.ce.common.model.response.Response;
import br.com.ce.usuario.model.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioResponse.
 */
public class UsuarioResponse extends Response
{

	/** The usuarios. */
	private List<Usuario> usuarios;

	/**
	 * Instantiates a new usuario response.
	 */
	public UsuarioResponse()
	{

	}

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios()
	{
		return usuarios;
	}

	/**
	 * Sets the usuarios.
	 *
	 * @param usuarios the new usuarios
	 */
	public void setUsuarios(List<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}

	/**
	 * Gets the first usuario.
	 *
	 * @return the first usuario
	 */
	public Usuario getFirstUsuario()
	{
		if (getUsuarios() != null && !getUsuarios().isEmpty())
		{
			return getUsuarios().get(0);
		}
		return null;
	}

}
