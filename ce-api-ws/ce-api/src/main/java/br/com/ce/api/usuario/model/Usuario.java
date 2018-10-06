package br.com.ce.api.usuario.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
public class Usuario
{
	/** The login. */
	private String login;

	/** The name. */
	private String name;
	

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario()
	{
		super();
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param login the login
	 * @param name the name
	 */
	public Usuario(String login, String name)
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
	

}
