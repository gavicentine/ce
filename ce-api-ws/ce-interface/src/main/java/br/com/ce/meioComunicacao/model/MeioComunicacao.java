/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.meioComunicacao.model;

import br.com.ce.common.model.GenericModel;

// TODO: Auto-generated Javadoc
/**
 * The Class MeioComunicacao.
 */
public class MeioComunicacao extends GenericModel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	private Integer codigo;

	/** The meio comunicacao tipo. */
	private MeioComunicacaoTipoEnum meioComunicacaoTipo;

	/** The descricao. */
	private String descricao;

	/** The ddd numero. */
	private String dddNumero;

	/** The ddi numero. */
	private String ddiNumero;

	/** The ramal numero. */
	private String ramalNumero;

	/**
	 * Instantiates a new meio comunicacao.
	 */
	public MeioComunicacao()
	{
	}

	/**
	 * Instantiates a new meio comunicacao.
	 *
	 * @param meioComunicacaoTipo the meio comunicacao tipo
	 */
	public MeioComunicacao(MeioComunicacaoTipoEnum meioComunicacaoTipo)
	{
		setMeioComunicacaoTipo(meioComunicacaoTipo);
	}

	/**
	 * Instantiates a new meio comunicacao.
	 *
	 * @param codigo the codigo
	 * @param meioComunicacaoTipo the meio comunicacao tipo
	 * @param descricao the descricao
	 * @param dddNumero the ddd numero
	 * @param ddiNumero the ddi numero
	 * @param ramalNumero the ramal numero
	 */
	public MeioComunicacao(Integer codigo, MeioComunicacaoTipoEnum meioComunicacaoTipo, String descricao,
			String dddNumero, String ddiNumero, String ramalNumero)
	{
		super();
		this.codigo = codigo;
		this.meioComunicacaoTipo = meioComunicacaoTipo;
		this.descricao = descricao;
		this.dddNumero = dddNumero;
		this.ddiNumero = ddiNumero;
		this.ramalNumero = ramalNumero;
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

	/**
	 * Gets the ddd numero.
	 *
	 * @return the ddd numero
	 */
	public String getDddNumero()
	{
		return dddNumero;
	}

	/**
	 * Sets the ddd numero.
	 *
	 * @param dddNumero the new ddd numero
	 */
	public void setDddNumero(String dddNumero)
	{
		this.dddNumero = dddNumero;
	}

	/**
	 * Gets the ddi numero.
	 *
	 * @return the ddi numero
	 */
	public String getDdiNumero()
	{
		return ddiNumero;
	}

	/**
	 * Sets the ddi numero.
	 *
	 * @param ddiNumero the new ddi numero
	 */
	public void setDdiNumero(String ddiNumero)
	{
		this.ddiNumero = ddiNumero;
	}

	/**
	 * Gets the ramal numero.
	 *
	 * @return the ramal numero
	 */
	public String getRamalNumero()
	{
		return ramalNumero;
	}

	/**
	 * Sets the ramal numero.
	 *
	 * @param ramalNumero the new ramal numero
	 */
	public void setRamalNumero(String ramalNumero)
	{
		this.ramalNumero = ramalNumero;
	}

	/**
	 * Gets the meio comunicacao tipo.
	 *
	 * @return the meio comunicacao tipo
	 */
	public MeioComunicacaoTipoEnum getMeioComunicacaoTipo()
	{
		return meioComunicacaoTipo;
	}

	/**
	 * Sets the meio comunicacao tipo.
	 *
	 * @param meioComunicacaoTipo the new meio comunicacao tipo
	 */
	public void setMeioComunicacaoTipo(MeioComunicacaoTipoEnum meioComunicacaoTipo)
	{
		this.meioComunicacaoTipo = meioComunicacaoTipo;
	}

	/**
	 * Sets the meio comunicacao tipo enum value.
	 *
	 * @param valueParam the new meio comunicacao tipo enum value
	 */
	public void setMeioComunicacaoTipoEnumValue(Integer valueParam)
	{
		setMeioComunicacaoTipo(MeioComunicacaoTipoEnum.enumForValue(valueParam));
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.GenericModel#toString()
	 */
	@Override
	public String toString()
	{
		return "MeioComunicacao [getCodigo()=" + getCodigo() + ", getDescricao()=" + getDescricao()
				+ ", getDddNumero()=" + getDddNumero() + ", getDdiNumero()=" + getDdiNumero() + ", getRamalNumero()="
				+ getRamalNumero() + ", getMeioComunicacaoTipo()="
				+ getMeioComunicacaoTipo() + ", toString()=" + super.toString() + "]";
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
		MeioComunicacao other = (MeioComunicacao)obj;
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
}
