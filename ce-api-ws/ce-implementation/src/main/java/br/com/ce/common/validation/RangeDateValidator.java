/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.validation;

import java.util.Date;
import java.util.List;

import br.com.ce.common.model.MessageInfo;
import br.com.ce.common.model.PersistanceActionEnum;

// TODO: Auto-generated Javadoc
/**
 * The Class RangeDateValidator.
 */
public class RangeDateValidator implements IValidator
{
	
	/** The Constant DATA_INICIAL_REQUIRED. */
	private static final String DATA_INICIAL_REQUIRED =
			"br.com.ce.rangedatevalidator.start.date.required";

	/** The Constant DATA_FINAL_REQUIRED. */
	private static final String DATA_FINAL_REQUIRED =
			"br.com.ce.rangedatevalidator.end.date.required";

	/** The Constant RANGEDATE_INVALID. */
	private static final String RANGEDATE_INVALID =
			"br.com.ce.rangedatevalidator.rangedate.invalid";

	/** The Constant DATE_REQUIRED. */
	private static final String DATE_REQUIRED =
			"br.com.ce.rangedatevalidator.date.required";

	/*
	 * (non-Javadoc)
	 * @see com.sensus.common.validation.IValidator#validate(com.sensus.common.validation.ValidationContext)
	 */

	public void validate(ValidationContext validationContext)
	{
		Date dataInicial =
				(Date)validationContext.getObjectToBeValidated(ObjectToBeValidatedEnum.DATA_INICIAL.getValue());

		Date dataFinal = (Date)validationContext.getObjectToBeValidated(ObjectToBeValidatedEnum.DATA_FINAL.getValue());

		PersistanceActionEnum action =
				(PersistanceActionEnum)validationContext.getValidationArguments().get(
						PersistanceActionEnum.getDefaultName());

		if (ValidationUtil.isNull(action))
		{
			validationContext.getMessages().add(MessageInfo.createFieldValidationError(DATE_REQUIRED));
			return;
		}

		switch (action)
		{
			case INSERT:
				ValidationUtil.isNull(dataInicial, DATA_INICIAL_REQUIRED, validationContext.getMessages());
				validateRangeDate(validationContext.getMessages(), dataInicial, dataFinal);
				break;
			default:
				ValidationUtil.isNull(dataInicial, DATA_INICIAL_REQUIRED, validationContext.getMessages());
				ValidationUtil.isNull(dataFinal, DATA_FINAL_REQUIRED, validationContext.getMessages());
				break;
		}

	}

	/**
	 * Validate range date.
	 *
	 * @param list the list
	 * @param initialDate the initial date
	 * @param endDate the end date
	 */
	private void validateRangeDate(List<MessageInfo> list, Date initialDate, Date endDate)
	{
		if (!ValidationUtil.isNull(initialDate) && !ValidationUtil.isNull(endDate))
		{
			if (endDate.before(initialDate))
			{
				list.add(MessageInfo.createFieldValidationError(RANGEDATE_INVALID));
			}
		}
	}

}
