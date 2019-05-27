package dao;

import java.util.List;

import model.Donation;
import model.Route;

/**
 * 
 * Interface de Dao para los recorridos de recoleccion de donaciones
 *
 */
public interface RouteDao extends GenericDao<Route> {

	/**
	 * Listado de las donaciones de un recorrido
	 * 
	 * @param idRoute
	 *            identificador del recorrido
	 * @return listado de donaciones para el recorrido
	 */
	public List<Donation> getDonations(long idRoute);
}
