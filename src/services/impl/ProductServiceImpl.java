package services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.ProductDao;
import factories.FactoryDaos;
import model.Product;
import services.ProductService;

public class ProductServiceImpl implements ProductService {
	EntityManager em;

	ProductDao productDao = FactoryDaos.getProductDao();

	private List<Product> products;

	public ProductServiceImpl() {
	}

	@Override
	public List<Product> getProducts() {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		productDao.setEntityManager(em);
		products = productDao.getProducts();
		em.close();
		return products;
	}

	@Override
	public Product getProduct(long id) {
		// em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		productDao.setEntityManager(em);
		Product product = productDao.findById(id);
		em.close();
		return product;
	}

	@Override
	public Product newProduct(Product product) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		productDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		productDao.save(product);
		et.commit();
		em.close();
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		productDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		productDao.update(product);
		et.commit();
		em.close();
		return product;
	}

	@Override
	public Product deleteProduct(long id) {
		Product product;
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		productDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		product = productDao.findById(id);
		product.setDeleted(true);
		productDao.update(product);
		et.commit();
		em.close();
		return product;
	}

}
