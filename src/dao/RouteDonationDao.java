package dao;

import java.util.List;

import model.RouteDonation;

public interface RouteDonationDao extends GenericDao<RouteDonation> {

	/**
	 * Listado de las donaciones de un recorrido
	 * 
	 * @param idRoute
	 *            identificador del recorrido
	 * @return listado de donaciones para el recorrido
	 */
	public List<RouteDonation> getRouteDonations(long idRoute);
}
