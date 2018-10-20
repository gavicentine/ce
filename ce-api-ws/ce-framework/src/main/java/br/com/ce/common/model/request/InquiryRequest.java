/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.model.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.ce.common.model.SortExpression;
import br.com.ce.common.model.UserContext;

// TODO: Auto-generated Javadoc
/**
 * The Class InquiryRequest.
 */
public class InquiryRequest extends Request
{

	/** The start row. */
	private Integer startRow = 0;

	/** The end row. */
	private Integer endRow = 0;

	/** The page size. */
	private Integer pageSize = 0;

	/** The start page. */
	private Integer startPage = 0;

	/** The sort expressions. */
	private final List<SortExpression> sortExpressions = new ArrayList<SortExpression>();

	/** The pre query count. */
	private Boolean preQueryCount = false;

	/** The max pre query count. */
	private Integer maxPreQueryCount = 0;

	/** The select all. */
	private Boolean selectAll = true;

	/**
	 * Instantiates a new inquiry request.
	 */
	public InquiryRequest()
	{
		super();
	}

	/**
	 * Instantiates a new inquiry request.
	 *
	 * @param userContext the user context
	 */
	public InquiryRequest(UserContext userContext)
	{
		super(userContext);
	}

	/**
	 * Gets the start row.
	 *
	 * @return the start row
	 */
	public Integer getStartRow()
	{
		return startRow;
	}

	/**
	 * Sets the start row.
	 *
	 * @param startRow the new start row
	 */
	public void setStartRow(Integer startRow)
	{
		this.startRow = startRow;
	}

	/**
	 * Gets the end row.
	 *
	 * @return the end row
	 */
	public Integer getEndRow()
	{
		return endRow;
	}

	/**
	 * Sets the end row.
	 *
	 * @param endRow the new end row
	 */
	public void setEndRow(Integer endRow)
	{
		this.endRow = endRow;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public Integer getPageSize()
	{
		return pageSize;
	}

	/**
	 * Gets the start page.
	 *
	 * @return the start page
	 */
	public Integer getStartPage()
	{
		return startPage;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	/**
	 * Sets the start page.
	 *
	 * @param startPage the new start page
	 */
	public void setStartPage(Integer startPage)
	{
		this.startPage = startPage;
	}

	/**
	 * Gets the sort expressions.
	 *
	 * @return the sort expressions
	 */
	public List<SortExpression> getSortExpressions()
	{
		return sortExpressions;
	}

	/**
	 * Gets the sort expression.
	 *
	 * @return the sort expression
	 */
	public String getSortExpression()
	{
		String prefix = "";
		StringBuilder sb = new StringBuilder();

		if (getSortExpressions() != null && getSortExpressions().size() > 0)
		{
			Collections.sort(getSortExpressions(), new Comparator<SortExpression>()
			{
				public int compare(SortExpression exp1, SortExpression exp2)
				{
					if (exp1.getPriority() != null && exp2.getPriority() != null)
					{
						return exp1.getPriority().compareTo(exp2.getPriority());
					}
					else if (exp1.getPriority() == null && exp2.getPriority() == null)
					{
						return 0;
					}
					else
					{
						if (exp1.getPriority() == null)
						{
							return 1;
						}
						return -1;
					}
				}
			});

			for (SortExpression exp : getSortExpressions())
			{
				sb.append(prefix + exp.toString());
				prefix = ", ";
			}
		}
		if (sb.length() == 0)
		{
			return null;
		}

		return sb.toString();
	}

	/**
	 * Adds the sort expressions.
	 *
	 * @param sortExpression the sort expression
	 */
	public void addSortExpressions(SortExpression sortExpression)
	{
		sortExpressions.add(sortExpression);
	}

	/**
	 * Checks if is pre query count.
	 *
	 * @return the boolean
	 */
	public Boolean isPreQueryCount()
	{
		return preQueryCount;
	}

	/**
	 * Sets the pre query count.
	 *
	 * @param preQueryCount the new pre query count
	 */
	public void setPreQueryCount(Boolean preQueryCount)
	{
		this.preQueryCount = preQueryCount;
	}

	/**
	 * Gets the max pre query count.
	 *
	 * @return the max pre query count
	 */
	public Integer getMaxPreQueryCount()
	{
		return maxPreQueryCount;
	}

	/**
	 * Sets the max pre query count.
	 *
	 * @param maxPreQueryCount the new max pre query count
	 */
	public void setMaxPreQueryCount(Integer maxPreQueryCount)
	{
		this.maxPreQueryCount = maxPreQueryCount;
	}

	/**
	 * Checks if is select all.
	 *
	 * @return the boolean
	 */
	public Boolean isSelectAll()
	{
		return selectAll;
	}

	/**
	 * Sets the select all.
	 *
	 * @param selectAll the new select all
	 */
	public void setSelectAll(Boolean selectAll)
	{
		this.selectAll = selectAll;
	}

}
