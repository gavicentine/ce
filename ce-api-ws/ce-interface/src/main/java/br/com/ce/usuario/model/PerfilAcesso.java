/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.usuario.model;

import br.com.ce.common.model.GenericModel;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilAcesso.
 */
public class PerfilAcesso extends GenericModel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	private Integer codigo;

	/** The nome. */
	private String nome;

	/** The descricao. */
	private String descricao;

	/**
	 * Instantiates a new perfil acesso.
	 */
	public PerfilAcesso()
	{
	}

	/**
	 * Instantiates a new perfil acesso.
	 *
	 * @param codigo the codigo
	 * @param nome the nome
	 */
	public PerfilAcesso(Integer codigo, String nome)
	{
		setCodigo(codigo);
		setNome(nome);
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

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Integer getCodigo()
	{
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.GenericModel#toString()
	 */
	@Override
	public String toString()
	{
		return "PerfilAcesso [getNome()=" + getNome() + ", getCodigo()=" + getCodigo() + ", toString()="
				+ super.toString() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (codigo == null ? 0 : codigo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		PerfilAcesso other = (PerfilAcesso)obj;
		if (codigo == null)
		{
			if (other.codigo != null)
			{
				return false;
			}
		}
		else if (!codigo.equals(other.codigo))
		{
			return false;
		}
		return true;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao()
	{
		return descricao;
	}

	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

}