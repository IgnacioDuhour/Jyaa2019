package dao;

import java.util.List;

import model.Product;

/**
 * 
 * Interface para el Dao de Productos
 *
 */
public interface ProductDao extends GenericDao<Product> {

	/**
	 * Listado de productos
	 * 
	 * @return listado de productos
	 */
	List<Product> getProducts();

}
