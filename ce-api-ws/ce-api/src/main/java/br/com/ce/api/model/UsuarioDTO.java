package br.com.ce.api.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDTO.
 */
public class UsuarioDTO {

	/** The login. */
	private String login;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new usuario DTO.
	 */
	public UsuarioDTO()
	{
		
	}

	/**
	 * Instantiates a new usuario DTO.
	 *
	 * @param login the login
	 * @param password the password
	 */
	public UsuarioDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
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
	
	
}
