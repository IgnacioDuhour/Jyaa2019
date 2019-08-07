package dao;

import java.util.List;

import model.Donation;

public interface DonationDao extends GenericDao<Donation> {

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

	/**
	 * Listado de las donaciones no retiradas
	 * 
	 * @return listado de donaciones
	 */
	public List<Donation> getAvailableDonations();
}
