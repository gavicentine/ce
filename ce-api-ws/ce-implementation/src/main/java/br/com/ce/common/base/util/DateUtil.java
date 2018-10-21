/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.base.util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public final class DateUtil
{

	/** The min date. */
	private static Calendar minDate = null;

	/** The max date. */
	private static Calendar maxDate = null;

	/** The min date list. */
	private static List<Calendar> minDateList = new ArrayList<Calendar>();

	/** The max date list. */
	private static List<Calendar> maxDateList = new ArrayList<Calendar>();

	/** The one day. */
	private static long ONE_DAY = 1000 * 60 * 60 * 24;

	/**
	 * Instantiates a new date util.
	 */
	private DateUtil()
	{
	}

	/**
	 * Static initialize which set the default values for min and max dates.
	 */
	static
	{
		// Build a calendar so I can build the default min and max values.
		Calendar cal = Calendar.getInstance();

		// Define the default min.
		cal.set(1600, 00, 01);
		// Remove the time portion.
		minDate = truncateTime(cal);
		// Add to list so compare will work.
		minDateList.add(minDate);

		// Repeat for max date value.
		cal.set(9999, 11, 31);
		maxDate = truncateTime(cal);
		maxDateList.add(maxDate);
	}

	// [start] Property setters

	/**
	 * Sets the min date list.
	 *
	 * @param list the new min date list
	 */
	public void setMinDateList(List<Calendar> list)
	{
		// Need to remove the time portion of the Date so the comparison will work.
		for (Calendar d : list)
		{
			minDateList.add(truncateTime(d));
		}
	}

	/**
	 * Sets the max date list.
	 *
	 * @param list the new max date list
	 */
	public void setMaxDateList(List<Calendar> list)
	{
		// Need to remove the time portion of the Date so the comparison will work.
		for (Calendar d : list)
		{
			maxDateList.add(truncateTime(d));
		}
	}

	/**
	 * Sets the min date.
	 *
	 * @param dte the new min date
	 */
	public void setMinDate(Calendar dte)
	{
		minDate = truncateTime(dte);
		minDateList.add(dte);
	}

	/**
	 * Sets the max date.
	 *
	 * @param dte the new max date
	 */
	public void setMaxDate(Calendar dte)
	{
		maxDate = truncateTime(dte);
		maxDateList.add(dte);
	}

	/**
	 * Gets the max date.
	 *
	 * @return the max date
	 */
	public static Date getMaxDate()
	{
		return maxDate.getTime();
	}

	/**
	 * Gets the max calendar date.
	 *
	 * @return the max calendar date
	 */
	public static Calendar getMaxCalendarDate()
	{
		return maxDate;
	}

	/**
	 * Gets the min date.
	 *
	 * @return the min date
	 */
	public static Date getMinDate()
	{
		return minDate.getTime();
	}

	/**
	 * Gets the min calendar date.
	 *
	 * @return the min calendar date
	 */
	public static Calendar getMinCalendarDate()
	{
		return minDate;
	}

	/**
	 * Checks if is min date.
	 *
	 * @param inDate the in date
	 * @return true, if is min date
	 */
	public static boolean isMinDate(Date inDate)
	{
		// Make sure we remove the time portion of the Date so the comparison works.
		Date dte = truncateTime(inDate);

		// Spin the list looking for a match
		for (Calendar d : minDateList)
		{
			if (dte.equals(truncateTime(d.getTime())))
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if is min date.
	 *
	 * @param inDate the in date
	 * @return true, if is min date
	 */
	public static boolean isMinDate(Calendar inDate)
	{
		return isMinDate(inDate.getTime());
	}

	/**
	 * Checks if is max date.
	 *
	 * @param inDate the in date
	 * @return true, if is max date
	 */
	public static boolean isMaxDate(Date inDate)
	{
		// Make sure we remove the time portion of the Date so the comparison works.
		Date dte = truncateTime(inDate);

		// Spin the list looking for a match.
		for (Calendar d : maxDateList)
		{
			if (dte.equals(truncateTime(d.getTime())))
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if is max date.
	 *
	 * @param inDate the in date
	 * @return true, if is max date
	 */
	public static boolean isMaxDate(Calendar inDate)
	{
		return isMaxDate(inDate.getTime());
	}

	/**
	 * Gets the days diff.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the days diff
	 */
	public static final long getDaysDiff(Date startDate, Date endDate)
	{
		long diff = 0;

		if (startDate.getTime() > endDate.getTime())
		{
			diff = startDate.getTime() - endDate.getTime();
		}
		else
		{
			diff = endDate.getTime() - startDate.getTime();
		}

		return diff / ONE_DAY;
	}

	/**
	 * Gets the years diff.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the years diff
	 */
	public static final int getYearsDiff(Calendar startDate, Calendar endDate)
	{
		return getYearsDiff(startDate.getTime(), endDate.getTime());
	}

	/**
	 * Gets the years diff.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the years diff
	 */
	public static final int getYearsDiff(Date startDate, Date endDate)
	{
		int years = 0;
		GregorianCalendar startGC = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		GregorianCalendar endGC = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

		if (startDate == null)
		{
			startDate = new Date();
		}
		if (endDate == null)
		{
			endDate = new Date();
		}

		/*
		 * Handle endDate after startDate
		 */
		if (!startDate.before(endDate))
		{
			startGC.setTimeInMillis(startDate.getTime());
			endGC.setTimeInMillis(endDate.getTime());
		}
		else
		{
			startGC.setTimeInMillis(endDate.getTime());
			endGC.setTimeInMillis(startDate.getTime());
		}

		if (startGC.get(Calendar.MONTH) == endGC.get(Calendar.MONTH)
				&& startGC.get(Calendar.DATE) == endGC.get(Calendar.DATE))
		{
			years = startGC.get(Calendar.YEAR) - endGC.get(Calendar.YEAR);
		}
		else
		{
			/* Handle years. */
			do
			{
				years++;
				endGC.add(Calendar.YEAR, 1);
			} while (!startGC.before(endGC));
			years--;
		}

		return years;
	}

	/**
	 * Compare.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return the int
	 */
	public static int compare(Date date1, Date date2)
	{
		return truncateTime(date1).compareTo(truncateTime(date2));
	}

	/**
	 * Compare.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return the int
	 */
	public static int compare(Calendar date1, Calendar date2)
	{
		return truncateTime(date1).compareTo(truncateTime(date2));
	}

	/**
	 * Truncate time.
	 *
	 * @param dte the dte
	 * @return the date
	 */
	public static Date truncateTime(Date dte)
	{
		return DateUtils.truncate(dte, Calendar.DATE);
	}

	/**
	 * Truncate time.
	 *
	 * @param cal the cal
	 * @return the calendar
	 */
	public static Calendar truncateTime(Calendar cal)
	{
		return DateUtils.truncate(cal, Calendar.DATE);
	}

	/**
	 * To date.
	 *
	 * @param data the data
	 * @return the date
	 */
	public static Date toDate(String data)
	{
		try
		{
			return DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR")).parse(data);
		}
		catch (Exception ex)
		{
		}
		return null;
	}

	/**
	 * To string.
	 *
	 * @param data the data
	 * @return the string
	 */
	public static String toString(Date data)
	{
		try
		{
			return DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR")).format(data);
		}
		catch (Exception ex)
		{
		}

		return null;
	}

	/**
	 * To first date of month.
	 *
	 * @param data the data
	 * @return the calendar
	 */
	public static final Calendar toFirstDateOfMonth(Date data)
	{
		Calendar hoje = Calendar.getInstance();
		hoje.setTime(data);
		hoje.set(Calendar.HOUR_OF_DAY, 0);
		hoje.set(Calendar.DAY_OF_MONTH, 1);

		return hoje;
	}
	
	/**
	 * To first date of month.
	 *
	 * @param data the data
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 * @param millisecond the millisecond
	 * @return the date
	 */
	public static final Date toFirstDateOfMonth(Date data, Integer hour, Integer minute, Integer second, Integer millisecond)
	{
		Calendar hoje = toFirstDateOfMonth(data);

		applyTimeDetails(hoje, hour, minute, second, millisecond);

		return hoje.getTime();
	}


	/**
	 * To last date of month.
	 *
	 * @param data the data
	 * @return the calendar
	 */
	public static final Calendar toLastDateOfMonth(Date data)
	{
		Calendar hoje = Calendar.getInstance();
		hoje.setTime(data);
		hoje.add(Calendar.MONTH, 1);
		hoje.set(Calendar.DAY_OF_MONTH, 1);
		hoje.add(Calendar.DAY_OF_MONTH, -1);

		return hoje;
	}

	/**
	 * To last date of month.
	 *
	 * @param data the data
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 * @param millisecond the millisecond
	 * @return the date
	 */
	public static final Date toLastDateOfMonth(Date data, Integer hour, Integer minute, Integer second, Integer millisecond)
	{
		Calendar hoje = toLastDateOfMonth(data);

		applyTimeDetails(hoje, hour, minute, second, millisecond);

		return hoje.getTime();
	}


	/**
	 * Apply time details.
	 *
	 * @param cal the cal
	 * @param hour the hour
	 * @param minute the minute
	 * @param second the second
	 * @param millisecond the millisecond
	 */
	private static final void applyTimeDetails(Calendar cal, Integer hour, Integer minute, Integer second, Integer millisecond)
	{
		if (hour != null)
		{
			cal.set(Calendar.HOUR_OF_DAY, hour);
		}

		if (minute != null)
		{
			cal.set(Calendar.MINUTE, minute);
		}

		if (second != null)
		{
			cal.set(Calendar.SECOND, second);
		}

		if (millisecond != null)
		{
			cal.set(Calendar.MILLISECOND, millisecond);
		}

	}

}
