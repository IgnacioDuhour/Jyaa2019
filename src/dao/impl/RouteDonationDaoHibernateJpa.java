package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

//import dao.RouteDao;
import model.RouteDonation;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Recorridos
 *
 */
public class RouteDonationDaoHibernateJpa extends RouteDonationDaoHibernateJpa<RouteDonation> implements RouteDonationDao {

	public RouteDonationDaoHibernateJpa() {
		super(RouteDonation.class);
	}

	public RouteDonationDaoHibernateJpa(EntityManager em) {
		super(RouteDonation.class);
		this.setEntityManager(em);
	}


}
