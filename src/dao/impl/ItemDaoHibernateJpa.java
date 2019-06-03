package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemDao;
import model.Item;

public class ItemDaoHibernateJpa extends GenericDaoHibernateJpa<Item> implements ItemDao {

	public ItemDaoHibernateJpa() {
		// TODO Auto-generated constructor stub
		super(Item.class);
	}

	public ItemDaoHibernateJpa(EntityManager em) {
		super(Item.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItems(long idDonation) {
		Query q = this.entityManager.createQuery("SELECT i FROM Donation d Join d.items i  WHERE d.id = :donation");
		q.setParameter("donation", idDonation);
		return q.getResultList();
	}
}
