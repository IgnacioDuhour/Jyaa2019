package dao.impl;

import javax.persistence.EntityManager;

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
}
