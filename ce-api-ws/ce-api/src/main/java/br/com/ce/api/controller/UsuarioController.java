package br.com.ce.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ce.api.exception.BadRequestException;
import br.com.ce.api.model.Usuario;
import br.com.ce.api.model.UsuarioRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioController.
 */
@Controller
@RequestMapping("/ce-api/user")
public class UsuarioController
{

	
	/**
	 * Fetch by login.
	 *
	 * @param login the login
	 * @return the usuario
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Usuario fetchByLogin(@RequestParam(value = "login", required = true) String login)	
	{	
		if (login != null && login.equals("gavicentine")) 
		{
			return new Usuario("gavicentine", "Guilherme");
		}

		return new Usuario("not found", "User not found");
	}

	/**
	 * Fetch all.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody	
	public List<Usuario> fetchAll()
	{
		return this.fetchAllUsuarios();
	}
	
	
	/**
	 * Login.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws BadRequestException the bad request exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> login(@RequestBody UsuarioRequest request) throws BadRequestException
	{
		
		if (request.getUsuarioDTO() == null ||
				request.getUsuarioDTO().getLogin() == null ||
				request.getUsuarioDTO().getPassword() == null)
		{
			throw new BadRequestException();	
		}
		
		if (request.getUsuarioDTO().getLogin().equals("gavicentine")) 
		{
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);	
		}
		
		
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	

	/**
	 * Fetch all usuarios.
	 *
	 * @return the list
	 */
	private List<Usuario> fetchAllUsuarios()
	{

		final List<Usuario> users = new ArrayList<Usuario>();
		users.add(new Usuario("gavicentine", "Guilherme"));
		users.add(new Usuario("vdvicentine", "Vinicius"));
		users.add(new Usuario("mdvicentine", "Mateus"));

		return users;
	}
}
