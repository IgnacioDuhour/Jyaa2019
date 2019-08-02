package controllers;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.User;
import services.UserService;
import services.impl.UserServiceImpl;

/**
 * 
 * Controlador rest de usuarios
 *
 */
@Path("/Users")
public class UserController {

	UserService userService = new UserServiceImpl();

	private String mensaje;

	public UserController() {
	}

	/**
	 * Listado de los usuarios
	 * 
	 * @param page
	 *            página a obtener
	 * @param size
	 *            tamaño de página
	 * @return listado de usuarios
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@DefaultValue("0") @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("size") int size) {
		List<User> users = userService.getUsers(page, size);
		return Response.ok().entity(users).build();
	}

	/**
	 * Listado de los usuarios con rol de usuario del banco
	 * 
	 * @param page
	 *            pagina a obtener
	 * @param size
	 *            tamaño de pagina
	 * @return listado de usuarios del banco
	 */
	@GET
	@Path("bankUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsersByType(@DefaultValue("0") @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("size") int size) {
		List<User> users = userService.getBankUsers(page, size);
		return Response.ok().entity(users).build();
	}

	/**
	 * Listado de los usuarios con rol de donante
	 * 
	 * @param page
	 *            pagina a obtener
	 * @param size
	 *            tamaño de pagina
	 * @return listado de donantes
	 */
	@GET
	@Path("donorUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonorUsers(@DefaultValue("0") @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("size") int size) {
		List<User> users = userService.getDonorUsers(page, size);
		return Response.ok().entity(users).build();
	}

	/**
	 * Recuperar un usuario a partir de un id
	 * 
	 * @param id
	 *            identificador del usuario
	 * @return devuelve el usuario con el id recibido como parametro
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") long id) {
		User usr = userService.getUser(id);
		if (usr.isDeleted()) {
			mensaje = "No se encontró el usuario";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		} else {
			return Response.ok().entity(usr).build();
		}
	}

	/**
	 * Creacion de un nuevo usuario
	 * 
	 * @param user
	 *            datos del usuario a crear
	 * @return usuario creado
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		User usr = userService.newUser(user);
		return Response.status(Response.Status.CREATED).entity(usr).build();
	}

	/**
	 * Modificacion de un usuario
	 * 
	 * @param user
	 *            usuario modificado
	 * @return usuario modificado
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) {
		User usr = userService.updateUser(user);
		return Response.ok().entity(usr).build();
	}

	/**
	 * Eliminacion de un usuario
	 * 
	 * @param id
	 *            identificador del usuario a eliminar
	 * @return
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") long id) {
		User usr = userService.deleteUser(id);
		return Response.accepted().entity(usr).build();
	}

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		User usr = userService.getUserByUsername(user.getUsername());
		if (usr.getName() == null) {
			mensaje = "No se encontró el usuario";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		} else if (user.getPassword().equals(usr.getPassword())) {
			String token = getToken(usr);
			usr.setToken(token);
			return Response.ok().entity(usr).build();
		} else {
			mensaje = "Nombre de usuario o password incorrecto";
			return Response.status(Response.Status.FORBIDDEN).entity(mensaje).build();
		}
	}

	private String getToken(User user) {
		String secretKey = "mySecretKey";
		String token = Jwts.builder().setId("BancoAlimentosLP").setSubject(user.getUsername())
				.claim("authorities", Claims.SUBJECT)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		return "Bearer " + token;
	}

}
