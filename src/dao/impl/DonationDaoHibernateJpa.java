package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public List<Donation> getRouteDonations(long idRoute) {
		// paginacion
		// .setFirstResult(page * size).setMaxResults(size)
		Query q = this.entityManager.createQuery("SELECT d FROM Route r Join r.donations r WHERE r.id = :route");
		q.setParameter("route", idRoute);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getDonations(int page, int size) {
		return this.entityManager.createQuery("SELECT d FROM Donation d").setFirstResult(page * size)
				.setMaxResults(size).getResultList();
	}
}
