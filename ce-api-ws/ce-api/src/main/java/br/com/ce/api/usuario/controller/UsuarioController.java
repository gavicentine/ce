package br.com.ce.api.usuario.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ce.api.auth.config.TokenManager;
import br.com.ce.api.base.model.BaseResponse.Status;
import br.com.ce.api.exception.BadRequestException;
import br.com.ce.api.usuario.model.Usuario;
import br.com.ce.api.usuario.model.UsuarioRequest;
import br.com.ce.api.usuario.model.UsuarioResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioController.
 */
@RestController
@RequestMapping(value = "/user")
public class UsuarioController
{

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	/** The Constant STR_NAME. */
	private static final String STR_NAME = "name";

	/** The Constant STR_LOGIN. */
	private static final String STR_LOGIN = "login";

	/** The token manager. */
	@Resource
	private TokenManager tokenManager;
	
	
	/**
	 * Login.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UsuarioResponse login(@RequestBody UsuarioRequest request) throws Exception
	{
		
		LOG.debug("### LOGIN ###");
		
		if (request.getUsuario() == null ||
				request.getUsuario().getLogin() == null ||
				request.getUsuario().getPassword() == null)
		{
			throw new BadRequestException("Missing fields.");
		}
		
		//usuarioService.find();
		
		//good login
		if (request.getUsuario().getLogin().equals("gavicentine"))
		{
			Map<String, Object> claims = new HashMap<>();
			claims.put(STR_LOGIN, request.getUsuario().getLogin());
			claims.put(STR_NAME, request.getUsuario().getName());
		
			//return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			return new UsuarioResponse(Status.SUCCESS, tokenManager.generate(claims), null);
		}
		
		return new UsuarioResponse(Status.ERROR, null, null);
	}	
	
	/**
	 * Register.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws BadRequestException the bad request exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public UsuarioResponse register(@RequestBody UsuarioRequest request) throws BadRequestException
	{
		
		LOG.debug("### REGISTER ###");
		
		if (request.getUsuario() == null ||
				request.getUsuario().getLogin() == null ||
				request.getUsuario().getPassword() == null ||
				request.getUsuario().getConfirmPassword() == null ||
				request.getUsuario().getName() == null)
		{
			throw new BadRequestException("Missing fields.");
		}
		
		//verificar se usuario ja existe no banco
		if (request.getUsuario().getLogin().equals("gavicentine"))
		{
			throw new BadRequestException("User "+ request.getUsuario().getLogin() +" already exists.");
		}
		
		if (!request.getUsuario().getPassword().equals(
				request.getUsuario().getConfirmPassword()))
		{
			throw new BadRequestException("Password and confirm password don't match.");
		}
		
		//registrar usuario
		//usuarioService.save();
		
		//return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		return new UsuarioResponse(Status.SUCCESS, null, null);
		
	}

	
	/**
	 * Fetch by login.
	 *
	 * @param login the login
	 * @return the usuario
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public UsuarioResponse findByLogin(@RequestParam(value = STR_LOGIN, required = true) String login)	
	{
		LOG.debug("### find user by login: {} ",login);
		if (login != null && login.equals("gavicentine")) 
		{
			return new UsuarioResponse(Status.SUCCESS, null, new Usuario("gavicentine", "Guilherme"));
		}

		return new UsuarioResponse(Status.SUCCESS, null, null);
	}

	/**
	 * Fetch all.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody	
	public List<Usuario> findAll()
	{
		LOG.debug("### find all users");
		return this.fetchAllUsuarios();
	}
	


	/**
	 * Fetch all usuarios.
	 *
	 * @return the list
	 */
	private List<Usuario> fetchAllUsuarios()
	{
		final List<Usuario> users = new ArrayList<>();
		users.add(new Usuario("gavicentine", "Guilherme"));
		users.add(new Usuario("vdvicentine", "Vinicius"));
		users.add(new Usuario("mdvicentine", "Mateus"));

		return users;
	}
}
