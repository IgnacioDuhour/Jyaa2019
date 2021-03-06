package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
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

import model.Donation;
import model.Item;
import services.DonationService;
import services.impl.DonationServiceImpl;

/**
 * 
 * Controlador de donaciones
 *
 */
@Path("/Donations")
public class DonationController {

	DonationService donationService = new DonationServiceImpl();

	public DonationController() {
	}

	/**
	 * Listado de donaciones
	 * 
	 * @param page
	 *            pagina a obtener
	 * @param size
	 *            tama�o de pagina
	 * @return listado de donaciones
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonations(@DefaultValue("0") @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("size") int size) {
		List<Donation> donations = donationService.getDonations(page, size);
		return Response.ok().entity(donations).build();
	}

	/**
	 * Listado de donaciones sin retirar
	 * 
	 * @return listado de donaciones
	 */
	@GET
	@Path("available")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAvailableDonations() {
		List<Donation> donations = donationService.getAvailableDonations();
		return Response.ok().entity(donations).build();
	}

	/**
	 * Recupera una donacion a partir de un id
	 * 
	 * @param id
	 *            id de la donacion
	 * @return devuelve una donacion
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonation(@PathParam("id") long id) {
		Donation donation = donationService.getDonation(id);
		return Response.ok().entity(donation).build();
	}

	/**
	 * Listado de los items de una donacion
	 * 
	 * @param id
	 *            identificador de la donacion
	 * @return listado de items
	 */
	@GET
	@Path("items/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonationItems(@PathParam("id") long id) {
		List<Item> items = donationService.getDonationItems(id);
		return Response.ok().entity(items).build();
	}

	/**
	 * Crea una nueva donacion
	 * 
	 * @param donation
	 *            donacion a guardad
	 * @return donacion guardada
	 */
	@POST
	@Consumes
	@Produces
	public Response newDonation(Donation donation) {
		donationService.newDonation(donation);
		return Response.ok().entity(donation).build();
	}

	/**
	 * Marca una donacion como retirada
	 * 
	 * @param id
	 *            id de la donacion
	 * @param donation
	 *            datos de retiro de la donacion
	 * @return donacion marcada como retirada
	 */
	@PUT
	@Path("mark/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response markCollected(@PathParam("id") long id, Donation donation) {
		donation = donationService.markCollected(id, donation.getCollectNumber(), donation.getCollectDate());
		return Response.ok().entity(donation).build();
	}
}
