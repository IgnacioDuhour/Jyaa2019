package dao.impl;

import javax.persistence.EntityManager;

import dao.DonationDao;
import model.Donation;

public class DonationDaoHibernateJpa extends GenericDaoHibernateJpa<Donation> implements DonationDao {

	public DonationDaoHibernateJpa() {
		super(Donation.class);
	}

	public DonationDaoHibernateJpa(EntityManager em) {
		super(Donation.class);
		this.setEntityManager(em);
	}
}
