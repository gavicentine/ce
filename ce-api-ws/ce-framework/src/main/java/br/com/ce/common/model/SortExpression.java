/* 
 * D2S Solucoes em TI
 * 
 * Copyright (c) 2015, All rights reserved. 
 *
 */
package br.com.ce.common.model;

// TODO: Auto-generated Javadoc
/**
 * The Class SortExpression.
 */
public class SortExpression
{

	/**
	 * The Enum Direction.
	 */
	public static enum Direction
	{

		/** The Ascending. */
		Ascending,
		
		/** The Descending. */
		Descending;
	}

	/** The field. */
	private String field;

	/** The direction. */
	private Direction direction = Direction.Ascending;

	/** The priority. */
	private Integer priority;

	/**
	 * Instantiates a new sort expression.
	 */
	public SortExpression()
	{

	}

	/**
	 * Instantiates a new sort expression.
	 *
	 * @param field the field
	 * @param direction the direction
	 */
	public SortExpression(String field, Direction direction)
	{
		setField(field);
		setDirection(direction);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		if (direction == Direction.Ascending)
		{
			return field;
		}
		else
		{
			return field + " DESC";
		}
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public String getField()
	{
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(String field)
	{
		this.field = field;
	}

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public Direction getDirection()
	{
		return direction;
	}

	/**
	 * Gets the direction value.
	 *
	 * @return the direction value
	 */
	public String getDirectionValue()
	{
		if (direction != Direction.Ascending)
		{
			return "DESC";
		}
		else
		{
			return "ASC";
		}
	}

	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public Integer getPriority()
	{
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}
}
