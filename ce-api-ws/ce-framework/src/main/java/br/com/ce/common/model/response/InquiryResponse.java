/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.response;

import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class InquiryResponse.
 */
public class InquiryResponse extends Response
{

	/** The results set info. */
	private ResultsSetInfo resultsSetInfo = null;

	/**
	 * Gets the results set info.
	 *
	 * @return the results set info
	 */
	public ResultsSetInfo getResultsSetInfo()
	{
		return resultsSetInfo;
	}

	/**
	 * Sets the results set info.
	 *
	 * @param resultsSetInfo the new results set info
	 */
	public void setResultsSetInfo(ResultsSetInfo resultsSetInfo)
	{
		this.resultsSetInfo = resultsSetInfo;
	}

	/**
	 * Adds the results.
	 *
	 * @param coll the coll
	 */
	@SuppressWarnings({"rawtypes"})
	public void addResults(Collection coll)
	{

	}

}
