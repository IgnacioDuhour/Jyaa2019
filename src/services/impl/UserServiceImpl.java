package services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.BankUserDao;
import dao.DonorDao;
import dao.UserDao;
import factories.FactoryDaos;
import model.User;
import services.UserService;

public class UserServiceImpl implements UserService {

	EntityManager em;

	UserDao userDao = FactoryDaos.getUserDao();
	BankUserDao bankUserDao = FactoryDaos.getBankUserDao();
	DonorDao donorDao = FactoryDaos.getDonorDao();
	private List<User> users;

	public UserServiceImpl() {
	}

	@Override
	public List<User> getUsers(int page, int size) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		userDao.setEntityManager(em);
		users = userDao.getUsers(page, size);
		em.close();
		return users;
	}

	@Override
	public User getUser(long id) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		userDao.setEntityManager(em);
		User user = userDao.findById(id);
		em.close();
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		userDao.setEntityManager(em);
		User user = userDao.getByUsername(username);
		em.close();
		return user;
	}

	@Override
	public User newUser(User user) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		userDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		userDao.save(user);
		et.commit();
		em.close();
		return user;
	}

	@Override
	public User updateUser(User user) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		userDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		userDao.update(user);
		et.commit();
		em.close();
		return user;
	}

	@Override
	public User deleteUser(long id) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		userDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		User user = userDao.findById(id);
		user.setDeleted(true);
		userDao.update(user);
		et.commit();
		em.close();
		return user;
	}

	@Override
	public List<User> getBankUsers(int page, int size) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		bankUserDao.setEntityManager(em);
		users = bankUserDao.getBankUsers(page, size);
		em.close();
		return users;
	}

	@Override
	public List<User> getDonorUsers(int page, int size) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		donorDao.setEntityManager(em);
		users = donorDao.getDonorUsers(page, size);
		em.close();
		return users;
	}

}
