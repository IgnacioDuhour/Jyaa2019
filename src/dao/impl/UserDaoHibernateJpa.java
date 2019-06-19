package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.UserDao;
import model.User;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Usuario
 *
 */
public class UserDaoHibernateJpa extends GenericDaoHibernateJpa<User> implements UserDao {

	public UserDaoHibernateJpa() {
		super(User.class);
	}

	public UserDaoHibernateJpa(EntityManager em) {
		super(User.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(int page, int size) {
		return this.entityManager.createQuery("SELECT u FROM User u WHERE u.deleted = false")
				.setFirstResult(page * size).setMaxResults(size).getResultList();
	}

}
