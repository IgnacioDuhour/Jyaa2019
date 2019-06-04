package util;

import java.util.List;

import dao.GenericDao;
import model.Route;

/**
 * 
 * Interface de Dao para los recorridos de recoleccion de donaciones
 *
 */
public interface RouteDao extends GenericDao<Route> {

	/**
	 * Listado de recorridos
	 * 
	 * @return listado de recorridos
	 */
	public List<Route> getRoutes();
}
