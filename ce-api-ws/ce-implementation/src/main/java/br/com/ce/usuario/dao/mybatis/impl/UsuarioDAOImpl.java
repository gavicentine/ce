/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.dao.mybatis.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import br.com.ce.common.base.util.MyBatisDAOUtil;
import br.com.ce.common.model.response.InternalResponse;
import br.com.ce.common.model.response.InternalResultsResponse;
import br.com.ce.usuario.dao.IUsuarioDAO;
import br.com.ce.usuario.model.Usuario;
import br.com.ce.usuario.model.request.UsuarioRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDAOImpl.
 */
public class UsuarioDAOImpl extends SqlSessionDaoSupport implements IUsuarioDAO
{

	/** The Constant MAP. */
	private static final String MAP = "UsuarioMap.";

	/** The Constant INSERT. */
	private static final String INSERT = MAP + "insert";

	/** The Constant UPDATE. */
	private static final String UPDATE = MAP + "update";
	
	/** The Constant UPDATE_SENHA. */
	private static final String UPDATE_SENHA = MAP + "updateSenha";

	/** The Constant SELECT. */
	private static final String SELECT = MAP + "select";

	/** The Constant DELETE. */
	private static final String DELETE = MAP + "delete";

	/* (non-Javadoc)
	 * @see br.com.ce.usuario.dao.IUsuarioDAO#insert(br.com.ce.usuario.model.request.UsuarioRequest)
	 */

	public InternalResultsResponse<Usuario> insert(UsuarioRequest request)
	{
		InternalResultsResponse<Usuario> response = new InternalResultsResponse<Usuario>();

		request.getUsuario().setUsuarioAlteracao(request.getUserContext().getLogin());

		MyBatisDAOUtil.doInsert(getSqlSession(), INSERT, request.getUsuario(), response);

		response.addResult(request.getUsuario());

		return response;
	}

	/* (non-Javadoc)
	 * @see br.com.ce.usuario.dao.IUsuarioDAO#update(br.com.ce.usuario.model.request.UsuarioRequest)
	 */

	public InternalResultsResponse<Usuario> update(UsuarioRequest request)
	{

		InternalResultsResponse<Usuario> response = new InternalResultsResponse<Usuario>();

		request.getUsuario().setUsuarioAlteracao(request.getUserContext().getLogin());

		MyBatisDAOUtil.doUpdate(getSqlSession(), UPDATE, request.getUsuario(), response);

		response.addResult(request.getUsuario());

		return response;

	}
	
	/* (non-Javadoc)
	 * @see br.com.ce.usuario.dao.IUsuarioDAO#updateSenha(br.com.ce.usuario.model.request.UsuarioRequest)
	 */

	public InternalResultsResponse<Usuario> updateSenha(UsuarioRequest request)
	{

		InternalResultsResponse<Usuario> response = new InternalResultsResponse<Usuario>();

		request.getUsuario().setUsuarioAlteracao(request.getUserContext().getLogin());

		MyBatisDAOUtil.doUpdate(getSqlSession(), UPDATE_SENHA, request.getUsuario(), response);

		response.addResult(request.getUsuario());

		return response;

	}

	
	/* (non-Javadoc)
	 * @see br.com.ce.usuario.dao.IUsuarioDAO#select(br.com.ce.usuario.model.request.UsuarioRequest)
	 */

	public InternalResultsResponse<Usuario> select(UsuarioRequest request)
	{
		InternalResultsResponse<Usuario> response = new InternalResultsResponse<Usuario>();

		MyBatisDAOUtil.doQueryForList(getSqlSession(), SELECT,
				request, response);

		return response;
	}

	/* (non-Javadoc)
	 * @see br.com.ce.usuario.dao.IUsuarioDAO#delete(br.com.ce.usuario.model.request.UsuarioRequest)
	 */

	public InternalResponse delete(UsuarioRequest request)
	{
		InternalResponse response = new InternalResponse();

		MyBatisDAOUtil.doRemove(getSqlSession(), DELETE, request.getUsuario(), response);

		return response;
	}


}
