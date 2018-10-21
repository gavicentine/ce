/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.validation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import br.com.ce.common.base.util.CommonRuntimeException;
import br.com.ce.common.model.MessageUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationController.
 */
public class ValidationController implements InitializingBean
{

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ValidationController.class);

	/** The validators. */
	private List<IValidator> validators = new ArrayList<IValidator>();

	/** The allow empty validator list. */
	private boolean allowEmptyValidatorList = false;

	/**
	 * Validate.
	 *
	 * @param validationContext the validation context
	 * @return true, if successful
	 */
	public boolean validate(ValidationContext validationContext)
	{
		if (checkValidationContext(validationContext))
		{
			return false;
		}

		for (IValidator validator : getValidators())
		{
			validator.validate(validationContext);
			if (validationContext.isStopProcessing())
			{
				break;
			}
		}

		return !MessageUtil.hasErrors(validationContext.getMessages(), true);
	}

	/**
	 * Check validation context.
	 *
	 * @param validationContext the validation context
	 * @return true, if successful
	 */
	private boolean checkValidationContext(ValidationContext validationContext)
	{
		if (validationContext == null)
		{
			throw new CommonRuntimeException("Validation context is null.");
		}

		if ((validationContext.getObjectsToBeValidated() == null)
				|| (validationContext.getObjectsToBeValidated().size() == 0))
		{
			LOG.error("Objects to be validated is empty.");
		}

		return false;
	}

	/**
	 * Sets the validators.
	 *
	 * @param newValidators the new validators
	 */
	public void setValidators(List<IValidator> newValidators)
	{
		if (newValidators.size() > 0)
		{
			validators.addAll(newValidators);
		}
	}

	/**
	 * Gets the validators.
	 *
	 * @return the validators
	 */
	protected List<IValidator> getValidators()
	{
		return validators;
	}

	/**
	 * Sets the allow empty validator list.
	 *
	 * @param allowEmptyValidatorList the new allow empty validator list
	 */
	public void setAllowEmptyValidatorList(boolean allowEmptyValidatorList)
	{
		this.allowEmptyValidatorList = allowEmptyValidatorList;
	}

	/**
	 * Checks if is allow empty validator list.
	 *
	 * @return true, if is allow empty validator list
	 */
	public boolean isAllowEmptyValidatorList()
	{
		return allowEmptyValidatorList;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 * Invoked after this bean is completely initialized and this is where we insure all the required properties are
	 * set.
	 */

	public void afterPropertiesSet() throws Exception
	{
		if ((validators.size() == 0) && !isAllowEmptyValidatorList())
		{
			throw new Exception("The validators property must be set.");
		}

		if (LOG.isDebugEnabled())
		{
			LOG.debug(getValidators().size() + " validators loaded.");
		}
	}

}
