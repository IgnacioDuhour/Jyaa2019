package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.MessageDao;
import model.Message;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Message
 *
 */
public class MessageDaoHibernateJpa extends GenericDaoHibernateJpa<Message> implements MessageDao {

	public MessageDaoHibernateJpa() {
		super(Message.class);
	}

	public MessageDaoHibernateJpa(EntityManager em) {
		super(Message.class);
		this.setEntityManager(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAllMessages(long idRoute) {
		Query q = this.entityManager.createQuery("SELECT m FROM Route r Join r.messages m WHERE r.id = :route");
		q.setParameter("route", idRoute);
		return q.getResultList();
	}

}
