package dao;

import java.util.List;

import model.Type;

/**
 * 
 * Interface de Dao tipo de producto
 *
 */
public interface TypeDao extends GenericDao<Type> {
	
	/**
	 * Listado de tipos de productos
	 * 
	 * @return Listado de tipos
	 */
	List<Type> getTypes();
}
