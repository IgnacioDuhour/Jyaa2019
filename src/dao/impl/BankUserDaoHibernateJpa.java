package dao.impl;

import javax.persistence.EntityManager;

import dao.BankUserDao;
import model.BankUser;

public class BankUserDaoHibernateJpa extends GenericDaoHibernateJpa<BankUser> implements BankUserDao {

	public BankUserDaoHibernateJpa() {
		super(BankUser.class);
	}

	public BankUserDaoHibernateJpa(EntityManager em) {
		super(BankUser.class);
		this.setEntityManager(em);
	}
}
