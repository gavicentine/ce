package br.com.ce.api.usuario.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRequest.
 */
public class UsuarioRequest
{

	/** The usuario. */
	private UsuarioSearch usuarioSearch;
	
	/** The usuario DTO. */
	private UsuarioDTO usuarioDTO;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UsuarioRequest [getUsuarioSearch()=" + this.getUsuarioSearch()+
				", getUsuarioDTO()=" + this.getUsuarioDTO() + ", toString()=" + super.toString()
				+ "]";
	}

	/**
	 * Gets the usuario DTO.
	 *
	 * @return the usuario DTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * Sets the usuario DTO.
	 *
	 * @param usuarioDTO the new usuario DTO
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
