package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.RouteDao;
import model.Donation;
import model.Route;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Recorridos
 *
 */
public class RouteDaoHibernateJpa extends GenericDaoHibernateJpa<Route> implements RouteDao {

	public RouteDaoHibernateJpa() {
		super(Route.class);
	}

	public RouteDaoHibernateJpa(EntityManager em) {
		super(Route.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getDonations(long idRoute) {
		// paginacion
		// .setFirstResult(page * size).setMaxResults(size)
		List<Donation> donations = this.entityManager.createQuery("SELECT d FROM Donation d").getResultList();
		return donations;
	}

}
