/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ce.common.model.GenericModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioSearch.
 */
public class UsuarioSearch extends GenericModel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The login. */
	private String login;

	/** The nome. */
	private String nome;

	/** The perfis acesso. */
	private List<PerfilAcesso> perfisAcesso;

	/** The usuarios situacao. */
	private List<UsuarioSituacaoEnum> usuariosSituacao;

	/** The usuarios tipo. */
	private List<UsuarioTipoEnum> usuariosTipo;

	/**
	 * Instantiates a new usuario search.
	 */
	public UsuarioSearch()
	{
		super();
	}

	/**
	 * Instantiates a new usuario search.
	 *
	 * @param login the login
	 * @param us the us
	 */
	public UsuarioSearch(String login, UsuarioSituacaoEnum us)
	{
		this();
		setLogin(login);
		addUsuarioSituacao(us);
	}

	/**
	 * Gets the usuarios situacao.
	 *
	 * @return the usuarios situacao
	 */
	public List<UsuarioSituacaoEnum> getUsuariosSituacao()
	{
		return usuariosSituacao;
	}

	/**
	 * Sets the usuarios situacao.
	 *
	 * @param usuariosSituacao the new usuarios situacao
	 */
	public void setUsuariosSituacao(List<UsuarioSituacaoEnum> usuariosSituacao)
	{
		this.usuariosSituacao = usuariosSituacao;
	}

	/**
	 * Gets the usuarios tipo.
	 *
	 * @return the usuarios tipo
	 */
	public List<UsuarioTipoEnum> getUsuariosTipo()
	{
		return usuariosTipo;
	}

	/**
	 * Sets the usuarios tipo.
	 *
	 * @param usuariosTipo the new usuarios tipo
	 */
	public void setUsuariosTipo(List<UsuarioTipoEnum> usuariosTipo)
	{
		this.usuariosTipo = usuariosTipo;
	}

	/**
	 * Gets the perfis acesso.
	 *
	 * @return the perfis acesso
	 */
	public List<PerfilAcesso> getPerfisAcesso()
	{
		return perfisAcesso;
	}

	/**
	 * Sets the perfis acesso.
	 *
	 * @param perfisAcesso the new perfis acesso
	 */
	public void setPerfisAcesso(List<PerfilAcesso> perfisAcesso)
	{
		this.perfisAcesso = perfisAcesso;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin()
	{
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}

	/**
	 * Adds the usuario situacao.
	 *
	 * @param us the us
	 */
	public void addUsuarioSituacao(UsuarioSituacaoEnum us)
	{
		if (getUsuariosSituacao() == null)
		{
			setUsuariosSituacao(new ArrayList<UsuarioSituacaoEnum>());
		}
		getUsuariosSituacao().add(us);
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

}
