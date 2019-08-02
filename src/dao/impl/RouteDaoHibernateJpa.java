package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.RouteDao;
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
	public List<Route> getRoutes() {
		return this.entityManager.createQuery("SELECT r FROM Route r WHERE r.deleted = false").getResultList();
	}

}
