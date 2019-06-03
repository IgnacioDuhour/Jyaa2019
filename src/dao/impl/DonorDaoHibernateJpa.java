package dao.impl;

import javax.persistence.EntityManager;

import dao.DonorDao;
import model.Donor;

public class DonorDaoHibernateJpa extends GenericDaoHibernateJpa<Donor> implements DonorDao {

	public DonorDaoHibernateJpa() {
		super(Donor.class);
	}

	public DonorDaoHibernateJpa(EntityManager em) {
		super(Donor.class);
		this.setEntityManager(em);
	}

}
