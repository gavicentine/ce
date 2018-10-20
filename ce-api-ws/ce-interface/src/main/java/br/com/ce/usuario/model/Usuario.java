/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import java.util.List;

import br.com.ce.caracteristica.model.Caracteristica;
import br.com.ce.common.model.UserContext;
import br.com.ce.pessoa.model.Pessoa;
import br.com.ce.usuario.model.UsuarioSituacaoEnum;
import br.com.ce.usuario.model.UsuarioTipoEnum;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
public class Usuario extends UserContext
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The senha. */
	private String senha;

	/** The frase senha. */
	private String fraseSenha;

	/** The usuario situacao. */
	private UsuarioSituacaoEnum usuarioSituacao;

	/** The usuario tipo. */
	private UsuarioTipoEnum usuarioTipo;

	/** The perfil acesso. */
	private PerfilAcesso perfilAcesso;

	/** The pessoa. */
	private Pessoa pessoa;

	/** The caracteristicas. */
	private List<Caracteristica> caracteristicas;


	/**
	 * Instantiates a new usuario.
	 */
	public Usuario()
	{
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param login the login
	 * @param pessoa the pessoa
	 * @param perfilAcesso the perfil acesso
	 * @param situacao the situacao
	 * @param tipo the tipo
	 */
	public Usuario(String login, Pessoa pessoa, PerfilAcesso perfilAcesso, UsuarioSituacaoEnum situacao,
			UsuarioTipoEnum tipo)
	{
		setLogin(login);
		setPessoa(pessoa);
		setPerfilAcesso(perfilAcesso);
		setUsuarioSituacao(situacao);
		setUsuarioTipo(tipo);
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param strLogin the str login
	 */
	public Usuario(String strLogin)
	{
		this();
		setLogin(strLogin);
	}

	/**
	 * Gets the perfil acesso.
	 *
	 * @return the perfil acesso
	 */
	public PerfilAcesso getPerfilAcesso()
	{
		return perfilAcesso;
	}

	/**
	 * Sets the perfil acesso.
	 *
	 * @param perfilAcesso the new perfil acesso
	 */
	public void setPerfilAcesso(PerfilAcesso perfilAcesso)
	{
		this.perfilAcesso = perfilAcesso;
	}

	/**
	 * Gets the senha.
	 *
	 * @return the senha
	 */
	public String getSenha()
	{
		return senha;
	}

	/**
	 * Sets the senha.
	 *
	 * @param senha the new senha
	 */
	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	/**
	 * Gets the frase senha.
	 *
	 * @return the frase senha
	 */
	public String getFraseSenha()
	{
		return fraseSenha;
	}

	/**
	 * Sets the frase senha.
	 *
	 * @param fraseSenha the new frase senha
	 */
	public void setFraseSenha(String fraseSenha)
	{
		this.fraseSenha = fraseSenha;
	}

	/**
	 * Gets the usuario situacao.
	 *
	 * @return the usuario situacao
	 */
	public UsuarioSituacaoEnum getUsuarioSituacao()
	{
		return usuarioSituacao;
	}

	/**
	 * Sets the usuario situacao.
	 *
	 * @param usuarioSituacao the new usuario situacao
	 */
	public void setUsuarioSituacao(UsuarioSituacaoEnum usuarioSituacao)
	{
		this.usuarioSituacao = usuarioSituacao;
	}

	/**
	 * Sets the usuario situacao enum value.
	 *
	 * @param valueParam the new usuario situacao enum value
	 */
	public void setUsuarioSituacaoEnumValue(String valueParam)
	{
		setUsuarioSituacao(UsuarioSituacaoEnum.enumForValue(valueParam));
	}

	/**
	 * Gets the pessoa.
	 *
	 * @return the pessoa
	 */
	public Pessoa getPessoa()
	{
		return pessoa;
	}

	/**
	 * Sets the pessoa.
	 *
	 * @param pessoa the new pessoa
	 */
	public void setPessoa(Pessoa pessoa)
	{
		this.pessoa = pessoa;
	}

	/**
	 * Gets the usuario tipo.
	 *
	 * @return the usuario tipo
	 */
	public UsuarioTipoEnum getUsuarioTipo()
	{
		return usuarioTipo;
	}

	/**
	 * Sets the usuario tipo.
	 *
	 * @param usuarioTipo the new usuario tipo
	 */
	public void setUsuarioTipo(UsuarioTipoEnum usuarioTipo)
	{
		this.usuarioTipo = usuarioTipo;
	}

	/**
	 * Sets the usuario tipo enum value.
	 *
	 * @param valueParam the new usuario tipo enum value
	 */
	public void setUsuarioTipoEnumValue(String valueParam)
	{
		setUsuarioTipo(UsuarioTipoEnum.enumForValue(valueParam));
	}

	/**
	 * Gets the caracteristicas.
	 *
	 * @return the caracteristicas
	 */
	public List<Caracteristica> getCaracteristicas()
	{
		return caracteristicas;
	}

	/**
	 * Sets the caracteristicas.
	 *
	 * @param caracteristicas the new caracteristicas
	 */
	public void setCaracteristicas(List<Caracteristica> caracteristicas)
	{
		this.caracteristicas = caracteristicas;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.GenericModel#toString()
	 */
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		return "Usuario [getPerfilAcesso()=" + getPerfilAcesso() + ", getSenha()=" + getSenha() + ", getFraseSenha()="
				+ getFraseSenha() + ", getUsuarioSituacao()=" + getUsuarioSituacao() + ", getPessoa()=" + getPessoa()
				+ ", getUsuarioTipo()=" + getUsuarioTipo() + ", toString()=" + super.toString() + "]";
	}

}
