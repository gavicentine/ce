/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.validation;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.ce.common.model.MessageInfo;
import br.com.ce.common.model.request.InquiryRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class PageSizeValidator.
 */
public class PageSizeValidator implements IValidator
{

	/** The Constant PAGE_SIZE_INVALID. */
	private static final String PAGE_SIZE_INVALID = "br.com.ce.pagesizevalidator.page.size.invalid";

	/** The Constant START_ROW_INVALID. */
	private static final String START_ROW_INVALID = "br.com.ce.pagesizevalidator.start.row.invalid";

	/** The allowed page size. */
	private String allowedPageSize;

	/**
	 * Gets the allowed page size.
	 *
	 * @return the allowed page size
	 */
	public String getAllowedPageSize()
	{
		return allowedPageSize;
	}

	/**
	 * Sets the allowed page size.
	 *
	 * @param allowedPageSize the new allowed page size
	 */
	public void setAllowedPageSize(String allowedPageSize)
	{
		this.allowedPageSize = allowedPageSize;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.validation.IValidator#validate(com.sensus.common.validation.ValidationContext)
	 */

	public void validate(ValidationContext validationContext)
	{
		InquiryRequest request =
				(InquiryRequest)validationContext
				.getObjectToBeValidated(InquiryRequest.class.getSimpleName());

		if (ValidationUtil.isNull(request) || ValidationUtil.isNull(request.getPageSize()))
		{
			return;
		}

		ValidationUtil.isNull(request.getStartRow(), START_ROW_INVALID, validationContext.getMessages());

		List<String> pageSizeList = Arrays.asList(StringUtils.split(getAllowedPageSize(), ","));
		if (!pageSizeList.contains(String.valueOf(request.getPageSize())))
		{
			validationContext.getMessages().add(
					MessageInfo.createFieldValidationError(PAGE_SIZE_INVALID, getAllowedPageSize()));
		}
	}

}
