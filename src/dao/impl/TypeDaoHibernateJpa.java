package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.TypeDao;
import model.Type;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de tipos de productos
 *
 */
public class TypeDaoHibernateJpa extends GenericDaoHibernateJpa<Type> implements TypeDao {

	public TypeDaoHibernateJpa() {
		super(Type.class);
	}

	public TypeDaoHibernateJpa(EntityManager em) {
		super(Type.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> getTypes() {
		return this.entityManager.createQuery("SELECT t FROM Type t").getResultList();
	}
}
