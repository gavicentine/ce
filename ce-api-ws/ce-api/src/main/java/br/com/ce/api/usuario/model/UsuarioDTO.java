package br.com.ce.api.usuario.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
public class UsuarioDTO extends Usuario
{
	
	/** The password. */
	private String password;
	
	/** The confirm password. */
	private String confirmPassword;

	/**
	 * Instantiates a new usuario.
	 */
	public UsuarioDTO()
	{
		super();
	}

	/**
	 * Instantiates a new usuario.
	 *
	 * @param login the login
	 * @param name the name
	 */
	public UsuarioDTO(String login, String name)
	{
		super(login, name);
	}	

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the confirm password.
	 *
	 * @return the confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Sets the confirm password.
	 *
	 * @param confirmPassword the new confirm password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

}
