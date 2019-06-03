package dao;

import java.util.List;

import model.Item;

public interface ItemDao extends GenericDao<Item> {

	/**
	 * 
	 * Listado de Items de una donacion
	 * 
	 * @param idDonation
	 *            identificador de la donacion a recuperar los items
	 * 
	 * @return listado de items
	 */
	List<Item> getItems(long idDonation);
}
