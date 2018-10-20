/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchString.
 */
public class SearchString implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The search value. */
	private String searchValue;

	/** The search type. */
	private SearchType searchType;

	/** The case sensitive. */
	private boolean caseSensitive;

	/** The working value. */
	private String workingValue;

	/**
	 * The Enum SearchType.
	 */
	public enum SearchType
	{

		/** The starts with. */
		STARTS_WITH,

		/** The ends with. */
		ENDS_WITH,

		/** The contains. */
		CONTAINS,

		/** The exact match. */
		EXACT_MATCH,

		/** The greater than. */
		GREATER_THAN,

		/** The less than. */
		LESS_THAN;
	}

	/**
	 * Instantiates a new search string.
	 */
	public SearchString()
	{
		super();
	}

	/**
	 * Instantiates a new search string.
	 *
	 * @param newSearchValue the new search value
	 * @param newSearchType the new search type
	 */
	public SearchString(String newSearchValue, SearchType newSearchType)
	{
		this(newSearchValue, newSearchType, false);
	}

	/**
	 * Instantiates a new search string.
	 *
	 * @param newSearchValue the new search value
	 * @param newSearchType the new search type
	 * @param newCaseSensitive the new case sensitive
	 */
	public SearchString(String newSearchValue, SearchType newSearchType, boolean newCaseSensitive)
	{
		this();
		setSearchValue(newSearchValue);
		setSearchType(newSearchType);
		setCaseSensitive(newCaseSensitive);
	}

	/**
	 * Sets the search value.
	 *
	 * @param newValue the new search value
	 */
	public void setSearchValue(String newValue)
	{
		searchValue = newValue;
	}

	/**
	 * Gets the search value.
	 *
	 * @return the search value
	 */
	public String getSearchValue()
	{
		return searchValue;
	}

	/**
	 * Sets the search type.
	 *
	 * @param newValue the new search type
	 */
	public void setSearchType(SearchType newValue)
	{
		searchType = newValue;
	}

	/**
	 * Gets the search type.
	 *
	 * @return the search type
	 */
	public SearchType getSearchType()
	{
		return searchType;
	}

	/**
	 * Sets the case sensitive.
	 *
	 * @param newValue the new case sensitive
	 */
	public void setCaseSensitive(Boolean newValue)
	{
		caseSensitive = newValue;
	}

	/**
	 * Checks if is case sensitive.
	 *
	 * @return the boolean
	 */
	public Boolean isCaseSensitive()
	{
		return caseSensitive;
	}

	/**
	 * Sets the working value.
	 *
	 * @param newValue the new working value
	 */
	public void setWorkingValue(String newValue)
	{
		workingValue = newValue;
	}

	/**
	 * Gets the working value.
	 *
	 * @return the working value
	 */
	@XmlTransient
	public String getWorkingValue()
	{
		if (StringUtils.isBlank(workingValue))
		{
			setWorkingValue(getSearchValue());
		}
		return workingValue;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "SearchString [getSearchValue()=" + getSearchValue() + ", getSearchType()=" + getSearchType()
				+ ", isCaseSensative()=" + isCaseSensitive() + ", getWorkingValue()=" + getWorkingValue() + "]";
	}

}
