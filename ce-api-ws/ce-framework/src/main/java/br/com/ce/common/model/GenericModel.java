/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import br.com.ce.common.model.RecordStatusEnum;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericModel.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("serial")
public class GenericModel implements java.io.Serializable {

	/** The usuario cadastro. */
	private String usuarioCadastro;

	/** The usuario alteracao. */
	private String usuarioAlteracao;

	/** The data cadastro. */
	private Date dataCadastro;

	/** The data alteracao. */
	private Date dataAlteracao;

	/** The record status. */
	private RecordStatusEnum recordStatus = RecordStatusEnum.NONE;

	/**
	 * Instantiates a new generic model.
	 */
	public GenericModel() {

	}

	/**
	 * Gets the usuario cadastro.
	 *
	 * @return the usuario cadastro
	 */
	public String getUsuarioCadastro() {
		return usuarioCadastro;
	}

	/**
	 * Sets the usuario cadastro.
	 *
	 * @param usuarioCadastro
	 *            the new usuario cadastro
	 */
	public void setUsuarioCadastro(String usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	/**
	 * Gets the usuario alteracao.
	 *
	 * @return the usuario alteracao
	 */
	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	/**
	 * Sets the usuario alteracao.
	 *
	 * @param usuarioAlteracao
	 *            the new usuario alteracao
	 */
	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	/**
	 * Gets the data cadastro.
	 *
	 * @return the data cadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * Sets the data cadastro.
	 *
	 * @param dataCadastro
	 *            the new data cadastro
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Gets the data alteracao.
	 *
	 * @return the data alteracao
	 */
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * Sets the data alteracao.
	 *
	 * @param dataAlteracao
	 *            the new data alteracao
	 */
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenericModel [getUsuarioCadastro()=" + getUsuarioCadastro()
				+ ", getUsuarioAlteracao()=" + getUsuarioAlteracao()
				+ ", getDataCadastro()=" + getDataCadastro()
				+ ", getDataAlteracao()=" + getDataAlteracao()
				+ ", getRecordStatus()=" + getRecordStatus() + ", toString()="
				+ super.toString() + "]";
	}

	/**
	 * Gets the record status.
	 *
	 * @return the record status
	 */
	public RecordStatusEnum getRecordStatus() {
		return recordStatus;
	}

	/**
	 * Sets the record status.
	 *
	 * @param recordStatus
	 *            the new record status
	 */
	public void setRecordStatus(RecordStatusEnum recordStatus) {
		this.recordStatus = recordStatus;
	}

}
