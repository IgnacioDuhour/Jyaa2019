package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public User getByUsername(String username) {
		Query q = this.entityManager
				.createQuery("SELECT u FROM User u WHERE u.deleted = false AND u.username = :username");
		q.setParameter("username", username);
		List<User> users = q.getResultList();
		if (users.isEmpty()) {
			return new User();
		} else {
			return (User) q.getResultList().get(0);
		}
	}

}
