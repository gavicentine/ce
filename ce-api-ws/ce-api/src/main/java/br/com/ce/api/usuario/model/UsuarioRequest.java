package br.com.ce.api.usuario.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRequest.
 */
public class UsuarioRequest
{

	/** The usuario. */
	private UsuarioSearch usuarioSearch;
	
	/** The usuario. */
	private UsuarioDTO usuario;

	/**
	 * Instantiates a new usuario request.
	 */
	public UsuarioRequest()
	{
		super();
	}

	/**
	 * Instantiates a new usuario request.
	 *
	 * @param usuarioSearch the usuario search
	 */
	public UsuarioRequest(UsuarioSearch usuarioSearch)
	{
		super();
		this.usuarioSearch = usuarioSearch;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public UsuarioSearch getUsuarioSearch()
	{
		return this.usuarioSearch;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuarioSearch the new usuario search
	 */
	public void setUsuarioSearch(UsuarioSearch usuarioSearch)
	{
		this.usuarioSearch = usuarioSearch;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}



}
