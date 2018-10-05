package br.com.ce.api.usuario.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ce.api.base.model.BaseResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioResponse.
 */
public class UsuarioResponse extends BaseResponse {
	
	/** The usuarios. */
	private List<Usuario> usuarios;
	
	/**
	 * Instantiates a new usuario response.
	 */
	public UsuarioResponse() {
		super();
	}
		

	/**
	 * Instantiates a new usuario response.
	 *
	 * @param status the status
	 * @param token the token
	 */
	public UsuarioResponse(Status status, String token) {
		super(status,token);
	}

	
	/**
	 * Instantiates a new usuario response.
	 *
	 * @param status the status
	 * @param usuario the usuario
	 */
	public UsuarioResponse(Status status, Usuario usuario) {
		super(status);
		addUsuario(usuario);
	}
	
	
	/**
	 * Adds the usuario.
	 *
	 * @param usuario the usuario
	 */
	private void addUsuario(Usuario usuario)
	{
		if (getUsuarios() == null) 
		{
			setUsuarios(new ArrayList<Usuario>());
		};
		
		getUsuarios().add(usuario);
	}
	

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	/**
	 * Sets the usuarios.
	 *
	 * @param usuarios the new usuarios
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
}
