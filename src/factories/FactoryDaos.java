package factories;

import javax.persistence.EntityManager;

import dao.DonationDao;
import dao.ItemDao;
import dao.ProductDao;
import dao.RoleDao;
import dao.TypeDao;
import dao.UserDao;
import dao.impl.DonationDaoHibernateJpa;
import dao.impl.ItemDaoHibernateJpa;
import dao.impl.ProductDaoHibernateJpa;
import dao.impl.RoleDaoHibernateJpa;
import dao.impl.TypeDaoHibernateJpa;
import dao.impl.UserDaoHibernateJpa;

public class FactoryDaos {

	static public UserDao getUserDao() {
		return new UserDaoHibernateJpa();
	}

	static public UserDao getUserDao(EntityManager em) {
		return new UserDaoHibernateJpa(em);
	}

	static public DonationDao getDonationDao() {
		return new DonationDaoHibernateJpa();
	}

	static public DonationDao getDonationProductDao(EntityManager em) {
		return new DonationDaoHibernateJpa(em);
	}

	static public ItemDao getItemDao() {
		return new ItemDaoHibernateJpa();
	}

	static public ItemDao getItemDao(EntityManager em) {
		return new ItemDaoHibernateJpa(em);
	}

	static public RoleDao getRoleDao() {
		return new RoleDaoHibernateJpa();
	}

	static public RoleDao getRoleDao(EntityManager em) {
		return new RoleDaoHibernateJpa(em);
	}

	static public TypeDao getTypeDao() {
		return new TypeDaoHibernateJpa();
	}

	static public TypeDao getTypeDao(EntityManager em) {
		return new TypeDaoHibernateJpa(em);
	}

	static public ProductDao getProductDao() {
		return new ProductDaoHibernateJpa();
	}

	static public ProductDao getProductDao(EntityManager em) {
		return new ProductDaoHibernateJpa(em);
	}


}
