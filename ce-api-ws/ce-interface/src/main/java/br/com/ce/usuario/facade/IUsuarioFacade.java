/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.facade;

import br.com.ce.usuario.model.request.UsuarioRequest;
import br.com.ce.usuario.model.response.UsuarioResponse;


// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioFacade.
 */
public interface IUsuarioFacade
{

	/**
	 * Insert.
	 *
	 * @param request the request
	 * @return the usuario response
	 */
	UsuarioResponse insert(UsuarioRequest request);

	/**
	 * Update.
	 *
	 * @param request the request
	 * @return the usuario response
	 */
	UsuarioResponse update(UsuarioRequest request);
	
	/**
	 * Update senha.
	 *
	 * @param request the request
	 * @return the usuario response
	 */
	UsuarioResponse updateSenha(UsuarioRequest request);

	/**
	 * Select.
	 *
	 * @param request the request
	 * @return the usuario response
	 */
	UsuarioResponse select(UsuarioRequest request);

	/**
	 * Delete.
	 *
	 * @param request the request
	 * @return the usuario response
	 */
	UsuarioResponse delete(UsuarioRequest request);

}
