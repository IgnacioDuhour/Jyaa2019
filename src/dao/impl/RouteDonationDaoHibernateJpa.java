package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.RouteDonationDao;
import model.RouteDonation;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Recorridos
 *
 */
public class RouteDonationDaoHibernateJpa extends GenericDaoHibernateJpa<RouteDonation> implements RouteDonationDao {

	public RouteDonationDaoHibernateJpa() {
		super(RouteDonation.class);
	}

	public RouteDonationDaoHibernateJpa(EntityManager em) {
		super(RouteDonation.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RouteDonation> getRouteDonations(long idRoute) {
		// paginacion
		// .setFirstResult(page * size).setMaxResults(size)
		Query q = this.entityManager.createQuery("SELECT d FROM Route r Join r.donations d WHERE r.id = :route");
		q.setParameter("route", idRoute);
		return q.getResultList();
	}
}
