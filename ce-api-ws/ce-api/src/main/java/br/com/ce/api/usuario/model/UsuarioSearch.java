package br.com.ce.api.usuario.model;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
public class UsuarioSearch
{
	/** The login. */
	private String login;

	/** The name. */
	private String name;

	/** The status. */
	private List<UsuarioStatus> statuses;

	/**
	 * Instantiates a new usuario.
	 */
	public UsuarioSearch()
	{
		super();
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param login the login
	 * @param name the name
	 */
	public UsuarioSearch(String login, String name)
	{
		super();
		this.login = login;
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin()
	{
		return this.login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public List<UsuarioStatus> getStatuses()
	{
		return this.statuses;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatuses(List<UsuarioStatus> statuses)
	{
		this.statuses = statuses;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Usuario [getName()=" + this.getName() + ", getLogin()=" + this.getLogin() + ", getStatuses()="
				+ this.getStatuses() +
				", toString()=" + super.toString() + "]";
	}

}
