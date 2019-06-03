package dao.impl;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		return this.entityManager.createQuery("SELECT p FROM Product p").getResultList();
	}
}
