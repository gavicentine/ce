/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model.request;

import br.com.ce.common.model.UserContext;
import br.com.ce.common.model.request.InquiryRequest;
import br.com.ce.usuario.model.Usuario;
import br.com.ce.usuario.model.UsuarioSearch;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRequest.
 */
public class UsuarioRequest extends InquiryRequest
{

	/** The usuario. */
	private Usuario usuario;

	/** The usuario search. */
	private UsuarioSearch usuarioSearch;

	/**
	 * Instantiates a new usuario request.
	 */
	public UsuarioRequest()
	{
		super();
	}

	/**
	 * Instantiates a new usuario request.
	 *
	 * @param userContext the user context
	 * @param usuario the usuario
	 */
	public UsuarioRequest(UserContext userContext, Usuario usuario)
	{
		super(userContext);
		setUsuario(usuario);
	}

	/**
	 * Instantiates a new usuario request.
	 *
	 * @param userContext the user context
	 * @param usuarioSearch the usuario search
	 */
	public UsuarioRequest(UserContext userContext, UsuarioSearch usuarioSearch)
	{
		super(userContext);
		setUsuarioSearch(usuarioSearch);
	}

	/**
	 * Gets the usuario search.
	 *
	 * @return the usuario search
	 */
	public UsuarioSearch getUsuarioSearch()
	{
		return usuarioSearch;
	}

	/**
	 * Sets the usuario search.
	 *
	 * @param usuarioSearch the new usuario search
	 */
	public void setUsuarioSearch(UsuarioSearch usuarioSearch)
	{
		this.usuarioSearch = usuarioSearch;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario()
	{
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

}
