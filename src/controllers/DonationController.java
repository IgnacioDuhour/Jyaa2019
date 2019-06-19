package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Donation;
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * Listado de donaciones
	 * 
	 * @param page
	 *            pagina a obtener
	 * @param size
	 *            tamaño de pagina
	 * @return listado de donaciones
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Donation> getDonations(@DefaultValue("0") @QueryParam("page") int page,
			@DefaultValue("10") @QueryParam("size") int size) {
		return donationService.getDonations(page, size);
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
	public Donation getDonation(@PathParam("id") long id) {
		return donationService.getDonation(id);
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
