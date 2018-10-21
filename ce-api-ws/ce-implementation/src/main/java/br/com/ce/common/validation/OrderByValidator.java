/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.validation;

import java.util.List;

import br.com.ce.common.model.MessageInfo;
import br.com.ce.common.model.SortExpression;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderByValidator.
 */
public class OrderByValidator implements IValidator
{

	/** The Constant SORT_REQUIRED. */
	private static final String SORT_REQUIRED = "br.com.ce.orderbyvalidator.sort.required";

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.validation.IValidator#validate(com.sensus.common.validation.ValidationContext)
	 */
	@SuppressWarnings("unchecked")

	public void validate(ValidationContext validationContext)
	{
		List<SortExpression> sortExpressionList =
				(List<SortExpression>)validationContext.getObjectToBeValidated(SortExpression.class.getSimpleName());

		validateOrderBy(validationContext.getMessages(), sortExpressionList);

	}

	/**
	 * Validate order by.
	 *
	 * @param list the list
	 * @param sortExpressionList the sort expression list
	 */
	private void validateOrderBy(List<MessageInfo> list, List<SortExpression> sortExpressionList)
	{
		ValidationUtil.isNullOrEmpty(sortExpressionList, SORT_REQUIRED, list);

		if (!ValidationUtil.isNullOrEmpty(sortExpressionList))
		{
			for (SortExpression sortExpression : sortExpressionList)
			{
				ValidationUtil.isNull(sortExpression, SORT_REQUIRED, list);
				ValidationUtil.isNullOrEmpty(sortExpression.getDirectionValue(),
						SORT_REQUIRED, list);
				ValidationUtil
				.isNullOrEmpty(sortExpression.getField(), SORT_REQUIRED, list);
			}
		}
	}
}
