package dao;

import java.util.List;

import model.User;

/**
 * 
 * Interface de Dao de Usuario
 *
 */
public interface UserDao extends GenericDao<User> {

	/**
	 * listado de usuarios paginado
	 * 
	 * @param page
	 *            pagina a recuperar
	 * @param size
	 *            tamaño de pagina
	 * @return listado de usuarios
	 */
	public List<User> getUsers(int page, int size);
}
