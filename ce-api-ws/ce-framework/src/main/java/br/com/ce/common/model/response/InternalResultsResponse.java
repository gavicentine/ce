/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.response;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class InternalResultsResponse.
 *
 * @param <T> the generic type
 */
public class InternalResultsResponse<T> extends InternalResponse
{

	/** The results list. */
	private List<T> resultsList = new ArrayList<T>();

	/** The results set info. */
	private ResultsSetInfo resultsSetInfo = null;

	/**
	 * Instantiates a new internal results response.
	 */
	public InternalResultsResponse()
	{
	}

	/**
	 * Instantiates a new internal results response.
	 *
	 * @param t the t
	 */
	public InternalResultsResponse(T t)
	{
		addResult(t);
	}

	/**
	 * Instantiates a new internal results response.
	 *
	 * @param ts the ts
	 */
	public InternalResultsResponse(List<T> ts)
	{
		addResults(ts);
	}

	/**
	 * Gets the results set info.
	 *
	 * @return the results set info
	 */
	public ResultsSetInfo getResultsSetInfo()
	{
		if (this.resultsSetInfo == null)
		{
			this.resultsSetInfo = new ResultsSetInfo();
		}

		return this.resultsSetInfo;
	}

	/**
	 * Gets the results list.
	 *
	 * @return the results list
	 */
	public List<T> getResultsList()
	{
		return this.resultsList;
	}

	/**
	 * Adds the result.
	 *
	 * @param value the value
	 */
	public void addResult(T value)
	{
		this.getResultsList().add(value);
	}

	/**
	 * Adds the results.
	 *
	 * @param values the values
	 */
	public void addResults(List<T> values)
	{
		this.getResultsList().addAll(values);
	}

	/**
	 * Gets the first result.
	 *
	 * @return the first result
	 */
	public T getFirstResult()
	{
		if (this.resultsList.size() > 0)
		{
			return this.resultsList.get(0);
		}
		return null;
	}

	/**
	 * Checks for results.
	 *
	 * @return true, if successful
	 */
	public boolean hasResults()
	{
		return this.getResultsList().size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.ezproc.common.model.response.InternalResponse#toString()
	 */
	@Override
	public String toString()
	{
		return "InternalResultsResponse [getResultsSetInfo()="
				+ getResultsSetInfo() + ", getResultsList()="
				+ getResultsList() + ", getFirstResult()=" + getFirstResult()
				+ ", hasResults()=" + hasResults() + "]";
	}

}
