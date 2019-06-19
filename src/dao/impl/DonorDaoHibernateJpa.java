package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import dao.DonorDao;
import model.Donor;
import model.User;

public class DonorDaoHibernateJpa extends GenericDaoHibernateJpa<Donor> implements DonorDao {

	public DonorDaoHibernateJpa() {
		super(Donor.class);
	}

	public DonorDaoHibernateJpa(EntityManager em) {
		super(Donor.class);
		this.setEntityManager(em);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getDonorUsers(int page, int size) {
		return this.entityManager.createQuery("SELECT d.owner FROM Donor d WHERE d.owner.deleted = false")
				.setFirstResult(page * size).setMaxResults(size).getResultList();
	}
}
