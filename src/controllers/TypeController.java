package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Type;
import services.TypeService;
import services.impl.TypeServiceImpl;

@Path("/Types")
public class TypeController {
	TypeService typeService = new TypeServiceImpl();

	public TypeController() {
	}

	/**
	 * Listado de tipos de productos
	 * 
	 * @return listado de tipos de productos
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTypes() {
		List<Type> types = typeService.getTypes();
		return Response.ok().entity(types).build();
	}

	/**
	 * Recupera un tipo con el id recibido
	 * 
	 * @param id
	 *            id del tipo a recuperar
	 * @return tipo recuperado
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getType(@PathParam("id") long id) {
		Type type = typeService.getType(id);
		return Response.ok().entity(type).build();
	}

	/**
	 * Crea un nuevo tipo de producto
	 * 
	 * @param type
	 *            tipo nuevo
	 * @return tipo creado
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addType(Type type) {
		Type tp = typeService.newType(type);
		return Response.ok().entity(tp).build();
	}

	/**
	 * Modifica un tipo de producto
	 * 
	 * @param type
	 *            tipo a modificar
	 * @return tipo modificado
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateType(Type type) {
		Type tp = typeService.updateType(type);
		return Response.ok().entity(tp).build();
	}

	/**
	 * Elimina el tipo de producto con el id recibido
	 * 
	 * @param id
	 *            id del tipo a eliminar
	 * @return tipo eliminado
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteType(@PathParam("id") long id) {
		Type tp = typeService.deleteType(id);
		return Response.ok().entity(tp).build();
	}
}