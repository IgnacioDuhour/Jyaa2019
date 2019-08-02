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

import model.Message;
import model.Route;
import model.RouteDonation;
import services.RouteService;
import services.impl.RouteServiceImpl;

@Path("/Routes")
public class RouteController {

	RouteService routeService = new RouteServiceImpl();

	public RouteController() {
	}

	/**
	 * Listado de recorridos disponibles
	 * 
	 * @return listado de recorridos
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoutes() {
		List<Route> routes = routeService.getRoutes();
		return Response.ok().entity(routes).build();
	}

	/**
	 * Listado de donaciones de un recorrido
	 * 
	 * @param id
	 *            id del recorrido a recuperar sus donaciones
	 * @return listado de donaciones
	 */
	@GET
	@Path("donations/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRouteDonations(@PathParam("id") long id) {
		List<RouteDonation> routeDonations = routeService.getRouteDonations(id);
		return Response.ok().entity(routeDonations).build();
	}

	/**
	 * Listado de mensajes de un recorrido
	 * 
	 * @param id
	 *            id del recorrido a recuperar sus mensajes
	 * @return listado de mensajes
	 */
	@GET
	@Path("messages/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRouteMessages(@PathParam("id") long id) {
		List<Message> routeMessages = routeService.getRouteMessages(id);
		return Response.ok().entity(routeMessages).build();
	}

	/**
	 * Recupera un recorrido a partir de su id
	 * 
	 * @param id
	 *            id del recorrido
	 * @return recorrido recuperado
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoute(@PathParam("id") long id) {
		Route route = routeService.getRoute(id);
		return Response.ok().entity(route).build();
	}

	/**
	 * Agrega un nuevo mensaje a un recorrido
	 * 
	 * @param id
	 *            id del recorrido
	 * @param message
	 *            mensaje a guardar en el recorrido
	 * @return recorrido con el mensaje nuevo guardado
	 */
	@POST
	@Path("messages/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(@PathParam("id") long id, Message message) {
		Route route = routeService.addMessage(id, message);
		return Response.ok().entity(route).build();
	}

	/**
	 * Crea un nuevo recorrido
	 * 
	 * @param route
	 *            recorrido a guardar
	 * @return recorrido guardado
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newRoute(Route route) {
		routeService.newRoute(route);
		return Response.ok().entity(route).build();
	}

	/**
	 * Modificacion de un recorrido
	 * 
	 * @param route
	 *            recorrido a modificar
	 * @return recorrido modificado
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRoute(Route route) {
		routeService.updateRoute(route);
		return Response.ok().entity(route).build();
	}

	/**
	 * Elimina un recorrido a partir de su id
	 * 
	 * @param id
	 *            id del recorrido a eliminar
	 * @return recorrido eliminado
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRoute(@PathParam("id") long id) {
		Route route = routeService.deleteRoute(id);
		return Response.accepted().entity(route).build();
	}
}
