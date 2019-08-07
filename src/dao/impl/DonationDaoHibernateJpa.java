package dao.impl;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getDonations(int page, int size) {
		return this.entityManager.createQuery("SELECT d FROM Donation d WHERE d.deleted = false")
				.setFirstResult(page * size).setMaxResults(size).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getAvailableDonations() {
		return this.entityManager.createQuery("SELECT d FROM Donation d WHERE d.collected = false").getResultList();
	}

}
