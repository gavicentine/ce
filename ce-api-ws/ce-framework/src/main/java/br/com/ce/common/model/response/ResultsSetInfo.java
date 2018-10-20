/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.response;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultsSetInfo.
 */
@XmlRootElement
public class ResultsSetInfo
{

	/** The start row. */
	private int startRow = 0;

	/** The end row. */
	private int endRow = 0;

	/** The more rows available. */
	private boolean moreRowsAvailable = false;

	/** The total rows available. */
	private int totalRowsAvailable = 0;

	/**
	 * Instantiates a new results set info.
	 */
	public ResultsSetInfo()
	{
	}

	/**
	 * Instantiates a new results set info.
	 *
	 * @param startRow the start row
	 * @param endRow the end row
	 * @param moreRowsAvailable the more rows available
	 */
	public ResultsSetInfo(int startRow, int endRow, boolean moreRowsAvailable)
	{
		this.startRow = startRow;
		this.endRow = endRow;
		this.moreRowsAvailable = moreRowsAvailable;
	}

	/**
	 * Instantiates a new results set info.
	 *
	 * @param startRow the start row
	 * @param endRow the end row
	 * @param moreRowsAvailable the more rows available
	 * @param totalRowsAvailable the total rows available
	 */
	public ResultsSetInfo(int startRow, int endRow, boolean moreRowsAvailable,
			int totalRowsAvailable)
	{
		this.startRow = startRow;
		this.endRow = endRow;
		this.moreRowsAvailable = moreRowsAvailable;
		this.totalRowsAvailable = totalRowsAvailable;
	}

	/**
	 * Gets the start row.
	 *
	 * @return the start row
	 */
	public int getStartRow()
	{
		return startRow;
	}

	/**
	 * Sets the start row.
	 *
	 * @param startRow the new start row
	 */
	public void setStartRow(int startRow)
	{
		this.startRow = startRow;
	}

	/**
	 * Gets the end row.
	 *
	 * @return the end row
	 */
	public int getEndRow()
	{
		return endRow;
	}

	/**
	 * Sets the end row.
	 *
	 * @param endRow the new end row
	 */
	public void setEndRow(int endRow)
	{
		this.endRow = endRow;
	}

	/**
	 * Checks if is more rows available.
	 *
	 * @return true, if is more rows available
	 */
	public boolean isMoreRowsAvailable()
	{
		return moreRowsAvailable;
	}

	/**
	 * Sets the more rows available.
	 *
	 * @param moreRowsAvailable the new more rows available
	 */
	public void setMoreRowsAvailable(boolean moreRowsAvailable)
	{
		this.moreRowsAvailable = moreRowsAvailable;
	}

	/**
	 * Gets the total rows available.
	 *
	 * @return the total rows available
	 */
	public int getTotalRowsAvailable()
	{
		return totalRowsAvailable;
	}

	/**
	 * Sets the total rows available.
	 *
	 * @param totalRowsAvailable the new total rows available
	 */
	public void setTotalRowsAvailable(int totalRowsAvailable)
	{
		this.totalRowsAvailable = totalRowsAvailable;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ResultsSetInfo [getStartRow()=" + getStartRow()
				+ ", getEndRow()=" + getEndRow() + ", isMoreRowsAvailable()="
				+ isMoreRowsAvailable() + ", getTotalRowsAvailable()="
				+ getTotalRowsAvailable() + "]";
	}

}
