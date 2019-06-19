package services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.UserDao;
import factories.FactoryDaos;
import model.User;
import services.UserService;

public class UserServiceImpl implements UserService {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persUnit");
	EntityManager em = emf.createEntityManager();

	UserDao userDao = FactoryDaos.getUserDao(em);

	public UserServiceImpl() {
	}

	@Override
	public List<User> getUsers(int page, int size) {
		return userDao.getUsers(page, size);
	}

	@Override
	public User getUser(long id) {
		return userDao.findById(id);
	}

	@Override
	public User newUser(User user) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		userDao.save(user);
		et.commit();
		return user;
	}

	@Override
	public User updateUser(User user) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		userDao.update(user);
		et.commit();
		return user;
	}

	@Override
	public User deletUser(long id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		User user = userDao.findById(id);
		user.setDeleted(true);
		userDao.update(user);
		et.commit();
		return user;
	}

}
