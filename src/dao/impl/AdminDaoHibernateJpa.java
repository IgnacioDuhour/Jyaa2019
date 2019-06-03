package dao.impl;

import javax.persistence.EntityManager;

import dao.AdminDao;
import model.Admin;

public class AdminDaoHibernateJpa extends GenericDaoHibernateJpa<Admin> implements AdminDao {

	public AdminDaoHibernateJpa() {
		super(Admin.class);
	}

	public AdminDaoHibernateJpa(EntityManager em) {
		super(Admin.class);
		this.setEntityManager(em);
	}

}
