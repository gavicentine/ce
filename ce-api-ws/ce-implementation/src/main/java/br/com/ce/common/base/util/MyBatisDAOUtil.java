/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.base.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ce.common.model.GenericModel;
import br.com.ce.common.model.GenericModelOL;
import br.com.ce.common.model.SearchString;
import br.com.ce.common.model.SearchString.SearchType;
import br.com.ce.common.model.request.InquiryRequest;
import br.com.ce.common.model.response.InternalResponse;
import br.com.ce.common.model.response.InternalResultsResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class MyBatisDAOUtil.
 */
public final class MyBatisDAOUtil
{
	
	/** The Constant DATABASE_WILDCARD. */
	private static final String DATABASE_WILDCARD = "%";

	/** The Constant OUT. */
	private static final String OUT = "out";

	/** The Constant PRETURN. */
	private static final String PRETURN = "p_return";

	/** The post no rows found error. */
	private static boolean postNoRowsFoundError = false;

	/** The post no rows updated error. */
	private static boolean postNoRowsUpdatedError = false;

	/** The post no rows removed error. */
	private static boolean postNoRowsRemovedError = false;

	/** The post no rows inserted error. */
	private static boolean postNoRowsInsertedError = false;

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(MyBatisDAOUtil.class);

	/**
	 * Instantiates a new my batis dao util.
	 */
	private MyBatisDAOUtil()
	{
	}

	/**
	 * Do update ol.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param model the model
	 * @param fetchVersioNumberStatementName the fetch versio number statement name
	 * @param resp the resp
	 * @return the int
	 */
	public static int doUpdateOL(SqlSession sqlSession, String statementName, GenericModelOL model,
			String fetchVersioNumberStatementName, InternalResponse resp)
	{
		int updateCount = sqlSession.update(statementName, model);

		// If update count is zero then we might have a problem with the WHERE clause
		// or an optimistic locking situation.
		if (updateCount == 0)
		{
			String logMsg = null;

			// Is the statement included ?
			if (fetchVersioNumberStatementName != null)
			{
				boolean match = checkVersion(sqlSession, fetchVersioNumberStatementName, model, resp);

				// If they match then there is most likely a key problem where the key values have changed which
				// caused the previous statement to return zero rows updated.
				if (match)
				{
					logMsg =
							"Update statement["
									+ statementName
									+ "] failed to update any rows with object type["
									+ model.getClass().getName()
									+ "] version number matches so it looks like the keys have changed or something caused no rows to be updated.";

					if (isPostNoRowsUpdatedError())
					{
						resp.setStatus(InternalResponse.Status.NoRowsUpdatedError);
					}
				}
				// If the version number is not the same than an optimistic locking error has occurred.
				// So we'll communicate back to the client an optimistic error.
				else if (resp.getStatus() == InternalResponse.Status.OptimisticLockingError)

				{
					logMsg = "Update statement[" + statementName + "] failed to update any rows with object type["
							+ model.getClass().getName() + "] Model object version=" + model.getVersion()
							+ "] DBMS version=" + resp.getStatusContextMap().get("currentversionnumber").toString()
							+ "]";
				}
				else
					// We couldn't look-up the version number.
				{
					logMsg = "Failed to verify version number using statement name[" + fetchVersioNumberStatementName
							+ "] for object type[" + model.getClass().getName() + "] typcially this indicates that "
							+ "the keys have changes for the table row.";
				}

			}
			else
			{
				if (isPostNoRowsUpdatedError())
				{
					resp.setStatus(InternalResponse.Status.NoRowsUpdatedError);
				}

				logMsg = "Update statement[" + statementName + "] failed to update any rows with object type["
						+ model.getClass().getName() + "] and no mybatis version number fetch statement was specified.";
			}

			LOG.error(logMsg);
		}

		return updateCount;
	}

	/**
	 * Check version.
	 *
	 * @param sqlSession the sql session
	 * @param fetchVersioNumberStatementName the fetch versio number statement name
	 * @param model the model
	 * @param resp the resp
	 * @return true, if successful
	 */
	public static boolean checkVersion(SqlSession sqlSession,
			String fetchVersioNumberStatementName, GenericModelOL model, InternalResponse resp)
	{
		// Try and get the version number for this root model object.
		Integer currentVersionNumber = (Integer)MyBatisDAOUtil.doQueryForObject(sqlSession,
				fetchVersioNumberStatementName, model);

		// If the version number is null than the statement failed to return anything
		// which is probably a problem since this may indicate that the root object/row does not exist.
		if (currentVersionNumber == null)
		{
			resp.setStatus(InternalResponse.Status.VersionNotFoundError);
			return false;
		}
		// If they don't match then someone/thing updated the root since we last read the data
		// and that is an optimistic locking error.
		else if (model.getVersion().equals(currentVersionNumber) == false)
		{
			resp.setStatus(InternalResponse.Status.OptimisticLockingError);
			resp.addStatusContextObject("currentversionnumber", currentVersionNumber);
			return false;
		}

		return true;
	}

	/**
	 * Do update.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param model the model
	 * @param resp the resp
	 * @return the int
	 */
	public static int doUpdate(SqlSession sqlSession, String statementName, GenericModel model,
			InternalResponse resp)
	{
		int updateCount = sqlSession.update(statementName, model);

		if (updateCount == 0)
		{
			if (model instanceof GenericModelOL)
			{
				String logMsg =
						"Update statement["
								+ statementName
								+ "] failed to update any rows with object type["
								+ model.getClass().getName()
								+ "] which is an instance of QATModelOL.  YOU SHOULD BE USING THE doUpdateOL METHOD INSTEAD !!!";
				LOG.error(logMsg);
			}

			if (isPostNoRowsUpdatedError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsUpdatedError);
			}
		}

		return updateCount;
	}

	/**
	 * Do update.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param hashMap the hash map
	 * @param resp the resp
	 * @return the int
	 */
	public static int doUpdate(SqlSession sqlSession, String statementName, HashMap<?, ?> hashMap,
			InternalResponse resp)
	{
		int updateCount = sqlSession.update(statementName, hashMap);

		if (updateCount == 0)
		{
			if (isPostNoRowsUpdatedError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsUpdatedError);
			}
		}

		return updateCount;
	}

	/**
	 * Do insert.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param model the model
	 * @param resp the resp
	 * @return the int
	 */
	public static int doInsert(SqlSession sqlSession, String statementName, GenericModel model,
			InternalResponse resp)
	{
		// Do the insert
		int insertCount = sqlSession.insert(statementName, model);

		if (insertCount == 0)
		{
			if (isPostNoRowsInsertedError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsInsertedError);
			}
		}

		return insertCount;
	}

	/**
	 * Do insert.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param hashMap the hash map
	 * @param resp the resp
	 * @return the object
	 */
	public static Object doInsert(SqlSession sqlSession, String statementName, HashMap<?, ?> hashMap,
			InternalResponse resp)
	{
		// Do the insert
		Object obj = sqlSession.insert(statementName, hashMap);

		return obj;
	}

	/**
	 * Do remove.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param resp the resp
	 * @return the int
	 */
	public static int doRemove(SqlSession sqlSession, String statementName, InternalResponse resp)
	{
		// Do the delete
		int deleteCount = sqlSession.delete(statementName);

		if (deleteCount == 0)
		{
			if (isPostNoRowsRemovedError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsRemovedError);
			}
		}

		return deleteCount;
	}

	/**
	 * Do remove ol.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param model the model
	 * @param fetchVersioNumberStatementName the fetch versio number statement name
	 * @param resp the resp
	 * @return the int
	 */
	public static int doRemoveOL(SqlSession sqlSession, String statementName, GenericModelOL model,
			String fetchVersioNumberStatementName, InternalResponse resp)
	{
		// Do the delete
		int deleteCount = sqlSession.delete(statementName, model);

		// If update count is zero then we might have a problem with the WHERE clause
		// or an optimistic locking situation.
		if (deleteCount == 0)
		{
			String logMsg = null;

			if (fetchVersioNumberStatementName != null)
			{
				boolean match = checkVersion(sqlSession, fetchVersioNumberStatementName, model, resp);

				if (match)
				{
					logMsg = "Remove statement[" + statementName + "] failed to remove any rows with object type["
							+ model.getClass().getName()
							+ "] version number matches so it looks like the keys have changed.";

					if (isPostNoRowsRemovedError())
					{
						resp.setStatus(InternalResponse.Status.NoRowsRemovedError);
					}
				}
				else if (resp.getStatus() == InternalResponse.Status.OptimisticLockingError)
				{
					logMsg = "Remove statement[" + statementName + "] failed to delete any rows with object type["
							+ model.getClass().getName() + "] Model object version=" + model.getVersion()
							+ "] DBMS version=" + resp.getStatusContextMap().get("currentversionnumber").toString()
							+ "]";
				}
				else
					// We couldn't look-up the version number.
				{
					logMsg = "Failed to verify version number using statement name[" + fetchVersioNumberStatementName
							+ "] for object type[" + model.getClass().getName() + "]";
				}
			}
			else
			{
				if (isPostNoRowsRemovedError())
				{
					resp.setStatus(InternalResponse.Status.NoRowsRemovedError);
				}

				logMsg = "Remove statement[" + statementName + "] failed to delete any rows with object type["
						+ model.getClass().getName() + "] and no mybatis version number fetch statement was specified.";
			}

			LOG.error(logMsg);
		}

		return deleteCount;
	}

	/**
	 * Do remove.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param model the model
	 * @param resp the resp
	 * @return the int
	 */
	public static int doRemove(SqlSession sqlSession, String statementName, GenericModel model,
			InternalResponse resp)
	{
		// Do the delete
		int deleteCount = sqlSession.delete(statementName, model);

		if (deleteCount == 0)
		{
			if (model instanceof GenericModelOL)
			{
				String logMsg =
						"Remove statement["
								+ statementName
								+ "] failed to remove any rows with object type["
								+ model.getClass().getName()
								+ "] which is an instance of QATModelOL.  YOU SHOULD BE USING THE doRemoveOL METHOD INSTEAD !!!";
				LOG.error(logMsg);
			}

			if (isPostNoRowsRemovedError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsRemovedError);
			}
		}

		return deleteCount;
	}

	/**
	 * Do remove.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param hashMap the hash map
	 * @param resp the resp
	 * @return the int
	 */
	public static int doRemove(SqlSession sqlSession, String statementName, HashMap<?, ?> hashMap,
			InternalResponse resp)
	{
		// Do the delete
		int deleteCount = sqlSession.delete(statementName, hashMap);

		if (deleteCount == 0)
		{
			if (isPostNoRowsRemovedError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsRemovedError);
			}
		}

		return deleteCount;
	}

	/**
	 * Do query for list.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param resp the resp
	 * @return the internal results response
	 */
	@SuppressWarnings("unchecked")
	public static InternalResultsResponse doQueryForList(SqlSession sqlSession,
			String statementName, InternalResultsResponse resp)
	{
		List list = sqlSession.selectList(statementName);

		if (list.size() > 0)
		{
			resp.getResultsList().addAll(list);
		}
		else
		{
			if (isPostNoRowsFoundError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsFoundError);
			}
		}

		return resp;
	}

	/**
	 * Do query for list.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param parameter the parameter
	 * @param resp the resp
	 * @return the internal results response
	 */
	@SuppressWarnings("unchecked")
	public static InternalResultsResponse doQueryForList(SqlSession sqlSession,
			String statementName, Object parameter, InternalResultsResponse resp)
	{
		List list = sqlSession.selectList(statementName, parameter);

		if (list.size() > 0)
		{
			resp.getResultsList().addAll(list);
		}
		else
		{
			if (isPostNoRowsFoundError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsFoundError);
			}
		}

		return resp;
	}

	/**
	 * Do query for list.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param parameter the parameter
	 * @return the list
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static List doQueryForList(SqlSession sqlSession, String statementName, HashMap parameter)
	{
		List result = sqlSession.selectList(statementName, parameter);

		if ((result == null || result.size() < 1) && parameter.containsKey(OUT))
		{
			result = (List)parameter.get(OUT);
		}
		return result;
	}

	/**
	 * Do query for object.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param resp the resp
	 * @return the internal results response
	 */
	@SuppressWarnings("unchecked")
	public static InternalResultsResponse<Object> doQueryForObject(SqlSession sqlSession,
			String statementName, InternalResultsResponse<Object> resp)
			{
		Object obj = sqlSession.selectOne(statementName);

		if (obj != null)
		{
			resp.addResult(obj);
		}
		else
		{
			if (isPostNoRowsFoundError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsFoundError);
			}
		}

		return resp;
			}

	/**
	 * Do query for object.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param parameter the parameter
	 * @param resp the resp
	 * @return the internal results response
	 */
	@SuppressWarnings("unchecked")
	public static InternalResultsResponse<Object> doQueryForObject(SqlSession sqlSession,
			String statementName, Object parameter, InternalResultsResponse<Object> resp)
			{
		Object obj = sqlSession.selectOne(statementName, parameter);

		if (obj != null)
		{
			resp.addResult(obj);
		}
		else
		{
			if (isPostNoRowsFoundError())
			{
				resp.setStatus(InternalResponse.Status.NoRowsFoundError);
			}
		}

		return resp;
			}

	/**
	 * Do query for object.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param parameter the parameter
	 * @return the object
	 */
	public static Object doQueryForObject(SqlSession sqlSession, String statementName, Object parameter)
	{
		return sqlSession.selectOne(statementName, parameter);
	}

	/**
	 * Do query for object.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @return the object
	 */
	public static Object doQueryForObject(SqlSession sqlSession, String statementName)
	{
		return sqlSession.selectOne(statementName);
	}

	/**
	 * Do query for object.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param parameter the parameter
	 * @return the object
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static Object doQueryForObject(SqlSession sqlSession, String statementName, HashMap parameter)
	{
		Object result = sqlSession.selectOne(statementName, parameter);

		/** Treat OUT parameter */
		if (result == null && parameter.containsKey(OUT))
		{
			if (parameter.containsKey(PRETURN) &&
					parameter.get(PRETURN) != null)
			{
				return parameter.get(PRETURN);
			}
			else
			{
				List resultObject = (ArrayList)parameter.get(OUT);

				if (resultObject != null && resultObject.size() > 0)
				{
					return resultObject.get(0);
				}
			}
		}
		else
		{
			if (result == null && parameter.containsKey(PRETURN))
			{
				Object resultObject = parameter.get(PRETURN);
				return resultObject;
			}
		}
		return result;
	}

	/**
	 * Do query for list.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @param parameter the parameter
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static List doQueryForList(SqlSession sqlSession, String statementName, Object parameter)
	{
		return sqlSession.selectList(statementName, parameter);
	}

	/**
	 * Do query for list.
	 *
	 * @param sqlSession the sql session
	 * @param statementName the statement name
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static List doQueryForList(SqlSession sqlSession, String statementName)
	{
		return sqlSession.selectList(statementName);
	}

	/**
	 * Initialize default paging.
	 *
	 * @param inquiryRequest the inquiry request
	 */
	public static void initializeDefaultPaging(InquiryRequest inquiryRequest)
	{
		// Default the page size if for some reason the page size is zero than default it to 20
		if (inquiryRequest.getPageSize() == 0)
		{
			inquiryRequest.setPageSize(20);
		}

		// If the start-row is set and the end-row is not than fix the end-row.
		if (inquiryRequest.getStartRow() > 0
				&& (inquiryRequest.getEndRow() == 0 || inquiryRequest.getEndRow() <= inquiryRequest.getStartRow()))
		{
			inquiryRequest.setEndRow(inquiryRequest.getStartRow() + inquiryRequest.getPageSize());
		}

		// If the end row is not set then default it to the page size.
		// Set up for row based paging.
		if (inquiryRequest.getEndRow() == 0)
		{
			inquiryRequest.setEndRow(inquiryRequest.getPageSize());
		}
	}

	// [start] Helper methods for Dynamic Search String object preparation

	/**
	 * Escape special characters.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String escapeSpecialCharacters(String text)
	{
		if (StringUtils.isBlank(text))
		{
			return text;
		}
		return text.replaceAll("(%|_|\\\\)", "\\\\$1");
	}

	/**
	 * Prepare starts with criteria.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String prepareStartsWithCriteria(String text)
	{
		if (StringUtils.isBlank(text))
		{
			return text;
		}
		return escapeSpecialCharacters(text) + DATABASE_WILDCARD;
	}

	/**
	 * Prepare contains criteria.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String prepareContainsCriteria(String text)
	{
		if (StringUtils.isBlank(text))
		{
			return text;
		}
		return DATABASE_WILDCARD + escapeSpecialCharacters(text) + DATABASE_WILDCARD;
	}

	/**
	 * Prepare ends with criteria.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String prepareEndsWithCriteria(String text)
	{
		if (StringUtils.isBlank(text))
		{
			return text;
		}
		return DATABASE_WILDCARD + escapeSpecialCharacters(text);
	}

	/**
	 * Prepare dynamic search string.
	 *
	 * @param searchString the search string
	 */
	public static void prepareDynamicSearchString(SearchString searchString)
	{
		if (searchString == null || StringUtils.isBlank(searchString.getSearchValue()))
		{
			return;
		}
		searchString.setWorkingValue(searchString.getSearchValue());
		if (!searchString.isCaseSensitive())
		{
			searchString.setWorkingValue(searchString.getSearchValue().toUpperCase());
		}

		if (searchString.getSearchType() == SearchType.STARTS_WITH)
		{
			searchString.setWorkingValue(prepareStartsWithCriteria(searchString.getWorkingValue()));
			return;
		}
		if (searchString.getSearchType() == SearchType.ENDS_WITH)
		{
			searchString.setWorkingValue(prepareEndsWithCriteria(searchString.getWorkingValue()));
			return;
		}
		if (searchString.getSearchType() == SearchType.CONTAINS)
		{
			searchString.setWorkingValue(prepareContainsCriteria(searchString.getWorkingValue()));
			return;
		}
	}

	/**
	 * Checks if is post no rows found error.
	 *
	 * @return true, if is post no rows found error
	 */
	public static boolean isPostNoRowsFoundError()
	{
		return postNoRowsFoundError;
	}

	/**
	 * Sets the post no rows found error.
	 *
	 * @param postNoRowsFoundError the new post no rows found error
	 */
	public static void setPostNoRowsFoundError(boolean postNoRowsFoundError)
	{
		MyBatisDAOUtil.postNoRowsFoundError = postNoRowsFoundError;
	}

	/**
	 * Checks if is post no rows updated error.
	 *
	 * @return true, if is post no rows updated error
	 */
	public static boolean isPostNoRowsUpdatedError()
	{
		return postNoRowsUpdatedError;
	}

	/**
	 * Sets the post no rows updated error.
	 *
	 * @param postNoRowsUpdatedError the new post no rows updated error
	 */
	public static void setPostNoRowsUpdatedError(boolean postNoRowsUpdatedError)
	{
		MyBatisDAOUtil.postNoRowsUpdatedError = postNoRowsUpdatedError;
	}

	/**
	 * Checks if is post no rows removed error.
	 *
	 * @return true, if is post no rows removed error
	 */
	public static boolean isPostNoRowsRemovedError()
	{
		return postNoRowsRemovedError;
	}

	/**
	 * Sets the post no rows removed error.
	 *
	 * @param postNoRowsRemovedError the new post no rows removed error
	 */
	public static void setPostNoRowsRemovedError(boolean postNoRowsRemovedError)
	{
		MyBatisDAOUtil.postNoRowsRemovedError = postNoRowsRemovedError;
	}

	/**
	 * Checks if is post no rows inserted error.
	 *
	 * @return true, if is post no rows inserted error
	 */
	public static boolean isPostNoRowsInsertedError()
	{
		return postNoRowsInsertedError;
	}

	/**
	 * Sets the post no rows inserted error.
	 *
	 * @param postNoRowsInsertedError the new post no rows inserted error
	 */
	public static void setPostNoRowsInsertedError(boolean postNoRowsInsertedError)
	{
		MyBatisDAOUtil.postNoRowsInsertedError = postNoRowsInsertedError;
	}

	// [end] Helper methods for Dynamic Search String object preparation
}
