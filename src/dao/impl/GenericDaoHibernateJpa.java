package dao.impl;

import javax.persistence.EntityManager;

import dao.GenericDao;

/**
 * 
 * Implementacion Jpa Hibernate del Dao Generico
 *
 * @param <T>
 */
public class GenericDaoHibernateJpa<T> implements GenericDao<T> {

	protected Class<T> persistentClass;

	protected EntityManager entityManager;

	public GenericDaoHibernateJpa() {
	}

	public GenericDaoHibernateJpa(Class<T> entityClass) {
		super();
		this.persistentClass = entityClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void remove(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public T findById(long id) {
		return entityManager.find(this.getPersistentClass(), id);
	}

}
