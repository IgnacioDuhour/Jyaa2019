package dao;

import java.util.List;

import model.Route;

/**
 * 
 * Interface de Dao para los recorridos de recoleccion de donaciones
 *
 */
public interface RouteDao2 extends GenericDao<Route> {

	/**
	 * Listado de recorridos
	 * 
	 * @return listado de recorridos
	 */
	public List<Route> getRoutes();
}
