package dao.impl;

import javax.persistence.EntityManager;

import dao.ProductDao;
import model.Product;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Productos
 *
 */
public class ProductDaoHibernateJpa extends GenericDaoHibernateJpa<Product> implements ProductDao {

	public ProductDaoHibernateJpa() {
		super(Product.class);
	}

	public ProductDaoHibernateJpa(EntityManager em) {
		super(Product.class);
		this.setEntityManager(em);
	}
}
