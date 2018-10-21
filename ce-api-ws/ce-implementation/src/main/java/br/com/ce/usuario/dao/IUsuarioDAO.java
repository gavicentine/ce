/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.dao;

import br.com.ce.common.model.response.InternalResponse;
import br.com.ce.common.model.response.InternalResultsResponse;
import br.com.ce.usuario.model.Usuario;
import br.com.ce.usuario.model.request.UsuarioRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioDAO.
 */
public interface IUsuarioDAO
{

	/**
	 * Insert.
	 *
	 * @param request the request
	 * @return the internal results response
	 */
	InternalResultsResponse<Usuario> insert(UsuarioRequest request);

	/**
	 * Update.
	 *
	 * @param request the request
	 * @return the internal results response
	 */
	InternalResultsResponse<Usuario> update(UsuarioRequest request);
	
	/**
	 * Update senha.
	 *
	 * @param request the request
	 * @return the internal results response
	 */
	InternalResultsResponse<Usuario> updateSenha(UsuarioRequest request);

	/**
	 * Select.
	 *
	 * @param request the request
	 * @return the internal results response
	 */
	InternalResultsResponse<Usuario> select(UsuarioRequest request);

	/**
	 * Delete.
	 *
	 * @param request the request
	 * @return the internal response
	 */
	InternalResponse delete(UsuarioRequest request);

}
