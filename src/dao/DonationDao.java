package dao;

import java.util.List;

import model.Donation;

public interface DonationDao extends GenericDao<Donation> {
	/**
	 * Listado de las donaciones de un recorrido
	 * 
	 * @param idRoute
	 *            identificador del recorrido
	 * @return listado de donaciones para el recorrido
	 */
	public List<Donation> getRouteDonations(long idRoute);

	/**
	 * Listado de las donaciones
	 * 
	 * @param page
	 *            pagina a recuperar
	 * @param size
	 *            tamaño de pagina
	 * @return listado de las donaciones
	 */
	public List<Donation> getDonations(int page, int size);
}
