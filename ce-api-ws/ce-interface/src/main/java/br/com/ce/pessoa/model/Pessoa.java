/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.pessoa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ce.caracteristica.model.Caracteristica;
import br.com.ce.common.model.GenericModel;
import br.com.ce.meioComunicacao.model.MeioComunicacao;
import br.com.ce.meioComunicacao.model.MeioComunicacaoTipoEnum;


// TODO: Auto-generated Javadoc
/**
 * The Class Pessoa.
 */
public abstract class Pessoa extends GenericModel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	private Integer codigo;

	/** The nome. */
	private String nome;

	/** The nome abreviado. */
	private String nomeAbreviado;

	/** The pessoa situacao. */
	private PessoaSituacaoEnum pessoaSituacao;

	/** The pessoa tipo. */
	private PessoaTipoEnum pessoaTipo;

	/** The data nascimento. */
	private Date dataNascimento;

	/** The sexo. */
	private PessoaSexoEnum sexo;

	/** The meios comunicacao. */
	private List<MeioComunicacao> meiosComunicacao;

	/** The caracteristicas. */
	private List<Caracteristica> caracteristicas;

	/**
	 * Instantiates a new pessoa.
	 */
	public Pessoa()
	{
		super();
		setPessoaSituacao(PessoaSituacaoEnum.ATIVO);
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
	 * Gets the meio comunicacao.
	 *
	 * @param tipo the tipo
	 * @return the meio comunicacao
	 */
	public MeioComunicacao getMeioComunicacao(MeioComunicacaoTipoEnum tipo)
	{
		for (MeioComunicacao mc : getMeiosComunicacao())
		{
			if (mc.getMeioComunicacaoTipo().equals(tipo))
			{
				return mc;
			}
		}

		return null;
	}

	

	/**
	 * Gets the telefone residencial.
	 *
	 * @return the telefone residencial
	 */
	public MeioComunicacao getTelefoneResidencial()
	{
		if ((getMeiosComunicacao() != null) && !getMeiosComunicacao().isEmpty())
		{
			for (MeioComunicacao mc : getMeiosComunicacao())
			{
				if (mc.getMeioComunicacaoTipo().equals(MeioComunicacaoTipoEnum.TELEFONE))
				{
					return mc;
				}
			}
		}
		return null;
	}


	/**
	 * Gets the celular.
	 *
	 * @return the celular
	 */
	public MeioComunicacao getCelular()
	{
		if ((getMeiosComunicacao() != null) && !getMeiosComunicacao().isEmpty())
		{
			for (MeioComunicacao mc : getMeiosComunicacao())
			{
				if (mc.getMeioComunicacaoTipo().equals(MeioComunicacaoTipoEnum.CELULAR))
				{
					return mc;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public MeioComunicacao getEmail()
	{
		if ((getMeiosComunicacao() != null) && !getMeiosComunicacao().isEmpty())
		{
			for (MeioComunicacao mc : getMeiosComunicacao())
			{
				if (mc.getMeioComunicacaoTipo().equals(MeioComunicacaoTipoEnum.EMAIL))
				{
					return mc;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the meios comunicacao.
	 *
	 * @return the meios comunicacao
	 */
	public List<MeioComunicacao> getMeiosComunicacao()
	{
		return meiosComunicacao;
	}

	/**
	 * Sets the meios comunicacao.
	 *
	 * @param meiosComunicacao the new meios comunicacao
	 */
	public void setMeiosComunicacao(List<MeioComunicacao> meiosComunicacao)
	{
		this.meiosComunicacao = meiosComunicacao;
	}

	/**
	 * Gets the nome abreviado.
	 *
	 * @return the nome abreviado
	 */
	public String getNomeAbreviado()
	{
		return nomeAbreviado;
	}

	/**
	 * Sets the nome abreviado.
	 *
	 * @param nomeAbreviado the new nome abreviado
	 */
	public void setNomeAbreviado(String nomeAbreviado)
	{
		this.nomeAbreviado = nomeAbreviado;
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
	 * Sets the pessoa tipo enum value.
	 *
	 * @param valueParam the new pessoa tipo enum value
	 */
	public void setPessoaTipoEnumValue(Integer valueParam)
	{
		setPessoaTipo(PessoaTipoEnum.enumForValue(valueParam));
	}

	/**
	 * Sets the pessoa situacao enum value.
	 *
	 * @param valueParam the new pessoa situacao enum value
	 */
	public void setPessoaSituacaoEnumValue(String valueParam)
	{
		setPessoaSituacao(PessoaSituacaoEnum.enumForValue(valueParam));
	}

	/**
	 * Gets the pessoa situacao.
	 *
	 * @return the pessoa situacao
	 */
	public PessoaSituacaoEnum getPessoaSituacao()
	{
		return pessoaSituacao;
	}

	/**
	 * Sets the pessoa situacao.
	 *
	 * @param pessoaSituacao the new pessoa situacao
	 */
	public void setPessoaSituacao(PessoaSituacaoEnum pessoaSituacao)
	{
		this.pessoaSituacao = pessoaSituacao;
	}

	/**
	 * Gets the pessoa tipo.
	 *
	 * @return the pessoa tipo
	 */
	public PessoaTipoEnum getPessoaTipo()
	{
		return pessoaTipo;
	}

	/**
	 * Sets the pessoa tipo.
	 *
	 * @param pessoaTipo the new pessoa tipo
	 */
	public void setPessoaTipo(PessoaTipoEnum pessoaTipo)
	{
		this.pessoaTipo = pessoaTipo;
	}




	/**
	 * Gets the data nascimento.
	 *
	 * @return the data nascimento
	 */
	public Date getDataNascimento()
	{
		return dataNascimento;
	}

	/**
	 * Sets the data nascimento.
	 *
	 * @param dataNascimento the new data nascimento
	 */
	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public PessoaSexoEnum getSexo()
	{
		return sexo;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param sexo the new sexo
	 */
	public void setSexo(PessoaSexoEnum sexo)
	{
		this.sexo = sexo;
	}

	/**
	 * Sets the sexo enum value.
	 *
	 * @param valueParam the new sexo enum value
	 */
	public void setSexoEnumValue(String valueParam)
	{
		setSexo(PessoaSexoEnum.enumForValue(valueParam));
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
		result = (prime * result) + (codigo == null ? 0 : codigo.hashCode());
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
		Pessoa other = (Pessoa)obj;
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

	/**
	 * Adds the caracteristica.
	 *
	 * @param c the c
	 */
	public void addCaracteristica(Caracteristica c)
	{
		if (getCaracteristicas() == null)
		{
			setCaracteristicas(new ArrayList<Caracteristica>());
		}
		getCaracteristicas().add(c);
	}

	/**
	 * Sets the caracteristica.
	 *
	 * @param c the new caracteristica
	 */
	public void setCaracteristica(Caracteristica c)
	{
		if (getCaracteristicas() == null)
		{
			setCaracteristicas(new ArrayList<Caracteristica>());
		}
		getCaracteristicas().set(0, c);
	}

	/**
	 * Checks for caract.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean hasCaract(Caracteristica c)
	{
		if (getCaracteristicas() != null && !getCaracteristicas().isEmpty())
		{
			return getCaracteristicas().contains(c);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see br.com.ce.common.model.GenericModel#toString()
	 */
	@Override
	public String toString()
	{
		return "Pessoa [getNome()=" + getNome() 
				+ ", getTelefoneResidencial()=" + getTelefoneResidencial() + ", getCelular()=" + getCelular() + ", getEmail()=" + getEmail()
				+ ", getMeiosComunicacao()=" + getMeiosComunicacao()
				+ ", getNomeAbreviado()=" + getNomeAbreviado() + ", getCodigo()=" + getCodigo()
				+ ", getPessoaSituacao()=" + getPessoaSituacao() + ", getSexo()=" + getSexo()
				+ ", hashCode()=" + hashCode() + ", getCaracteristicas()="
				+ getCaracteristicas() + ", getUsuarioCadastro()=" + getUsuarioCadastro() + ", getUsuarioAlteracao()="
				+ getUsuarioAlteracao() + ", getDataCadastro()=" + getDataCadastro() + ", getDataAlteracao()="
				+ getDataAlteracao() + ", toString()=" + super.toString() + ", getRecordStatus()=" + getRecordStatus()
				+ ", getClass()=" + getClass() + "]";
	}

}
