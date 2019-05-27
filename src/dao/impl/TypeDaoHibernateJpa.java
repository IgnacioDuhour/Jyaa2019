package dao.impl;

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
}
