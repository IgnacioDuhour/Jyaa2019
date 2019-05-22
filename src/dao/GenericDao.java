package dao;

public interface GenericDao<T> {

	public void remove(T entity);

	public void update(T entity);

	public void save(T entity);

	public Object findById(long id);
}
