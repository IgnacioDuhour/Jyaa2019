package dao;

/**
 * 
 * Interface de Dao Generico
 *
 * @param <T> parametro generico de la clase
 */
public interface GenericDao<T> {

	public void remove(T entity);

	public void update(T entity);

	public void save(T entity);

	public T findById(long id);
}
