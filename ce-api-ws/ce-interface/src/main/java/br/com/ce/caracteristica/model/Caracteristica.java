/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.caracteristica.model;

import br.com.ce.caracteristica.model.CaracteristicaTipoEnum;
import br.com.ce.common.model.GenericModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Caracteristica.
 */
public class Caracteristica extends GenericModel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	private Integer codigo;

	/** The nome. */
	private String nome;

	/** The descricao. */
	private String descricao;

	/** The valor. */
	private String valor;

	/** The caracteristica tipo. */
	private CaracteristicaTipoEnum caracteristicaTipo;

	/**
	 * Instantiates a new caracteristica.
	 */
	public Caracteristica()
	{
	}

	/**
	 * Instantiates a new caracteristica.
	 *
	 * @param codigo the codigo
	 * @param nome the nome
	 * @param valor the valor
	 * @param caracteristicaTipo the caracteristica tipo
	 */
	public Caracteristica(Integer codigo, String nome, String valor, CaracteristicaTipoEnum caracteristicaTipo)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.caracteristicaTipo = caracteristicaTipo;
	}

	/**
	 * Instantiates a new caracteristica.
	 *
	 * @param codigo the codigo
	 */
	public Caracteristica(Integer codigo)
	{
		super();
		this.codigo = codigo;

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
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public String getValor()
	{
		return valor;
	}

	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(String valor)
	{
		this.valor = valor;
	}

	/**
	 * Gets the caracteristica tipo.
	 *
	 * @return the caracteristica tipo
	 */
	public CaracteristicaTipoEnum getCaracteristicaTipo()
	{
		return caracteristicaTipo;
	}

	/**
	 * Sets the caracteristica tipo.
	 *
	 * @param caracteristicaTipo the new caracteristica tipo
	 */
	public void setCaracteristicaTipo(CaracteristicaTipoEnum caracteristicaTipo)
	{
		this.caracteristicaTipo = caracteristicaTipo;
	}

	/**
	 * Sets the caracteristica tipo enum value.
	 *
	 * @param valueParam the new caracteristica tipo enum value
	 */
	public void setCaracteristicaTipoEnumValue(String valueParam)
	{
		setCaracteristicaTipo(CaracteristicaTipoEnum.enumForValue(valueParam));
	}

	/* (non-Javadoc)
	 * @see br.com.ce.common.model.GenericModel#toString()
	 */
	@Override
	public String toString()
	{
		return "Caracteristica [getCodigo()=" + getCodigo() + ", getNome()=" + getNome() + ", getValor()=" + getValor()
				+ ", getCaracteristicaTipo()=" + getCaracteristicaTipo() + ", toString()=" + super.toString() + "]";
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
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
		Caracteristica other = (Caracteristica)obj;
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
