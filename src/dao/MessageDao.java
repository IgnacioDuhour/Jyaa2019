package dao;
import java.util.List;

import model.Message;


public interface MessageDao extends GenericDao<Message> {	
	/**
	 * Listado de los message de un recorrido
	 * 
	 * @param idRoute
	 *            identificador del recorrido
	 * @return listado de donaciones para el recorrido
	 */
	public List<Message> getAllMessages(long idRoute);

}
