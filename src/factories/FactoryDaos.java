package factories;

import javax.persistence.EntityManager;

import dao.AdminDao;
import dao.BankUserDao;
import dao.DonationDao;
import dao.DonorDao;
import dao.ItemDao;
import dao.ProductDao;
import dao.RouteDao;
import dao.RouteDonationDao;
import dao.TypeDao;
import dao.UserDao;
import dao.impl.AdminDaoHibernateJpa;
import dao.impl.BankUserDaoHibernateJpa;
import dao.impl.DonationDaoHibernateJpa;
import dao.impl.DonorDaoHibernateJpa;
import dao.impl.ItemDaoHibernateJpa;
import dao.impl.ProductDaoHibernateJpa;
import dao.impl.RouteDaoHibernateJpa;
import dao.impl.RouteDonationDaoHibernateJpa;
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

	static public DonationDao getDonationDao(EntityManager em) {
		return new DonationDaoHibernateJpa(em);
	}

	static public ItemDao getItemDao() {
		return new ItemDaoHibernateJpa();
	}

	static public ItemDao getItemDao(EntityManager em) {
		return new ItemDaoHibernateJpa(em);
	}

	static public AdminDao getAdminDao() {
		return new AdminDaoHibernateJpa();
	}

	static public AdminDao getAdminDao(EntityManager em) {
		return new AdminDaoHibernateJpa(em);
	}

	static public BankUserDao getBankUserDao() {
		return new BankUserDaoHibernateJpa();
	}

	static public BankUserDao getBankUserDao(EntityManager em) {
		return new BankUserDaoHibernateJpa(em);
	}

	static public DonorDao getDonorDao() {
		return new DonorDaoHibernateJpa();
	}

	static public DonorDao getDonorDao(EntityManager em) {
		return new DonorDaoHibernateJpa(em);
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

	static public RouteDao getRouteDao() {
		return new RouteDaoHibernateJpa();
	}

	static public RouteDao getRouteDao(EntityManager em) {
		return new RouteDaoHibernateJpa(em);
	}
	
	static public RouteDonationDao getRouteDonationDao() {
		return new RouteDonationDaoHibernateJpa();
	}

	static public RouteDonationDao getRouteDonationDao(EntityManager em) {
		return new RouteDonationDaoHibernateJpa(em);
	}
}
