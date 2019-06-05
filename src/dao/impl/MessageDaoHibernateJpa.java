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

	@Override
	public List<Message> getAllMessages(long idRoute) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(int page, int size) {
		return this.entityManager.createQuery("SELECT u FROM User u").setFirstResult(page * size).setMaxResults(size).getResultList();
	}*/

}
