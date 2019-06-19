package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.BankUserDao;
import model.BankUser;
import model.User;

public class BankUserDaoHibernateJpa extends GenericDaoHibernateJpa<BankUser> implements BankUserDao {

	public BankUserDaoHibernateJpa() {
		super(BankUser.class);
	}

	public BankUserDaoHibernateJpa(EntityManager em) {
		super(BankUser.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getBankUsers(int page, int size) {
		return this.entityManager.createQuery("SELECT bc.owner FROM BankUser bc WHERE bc.owner.deleted = false")
				.setFirstResult(page * size).setMaxResults(size).getResultList();
	}

}
