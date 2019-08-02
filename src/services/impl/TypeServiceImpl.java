package services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.TypeDao;
import factories.FactoryDaos;
import model.Type;
import services.TypeService;

public class TypeServiceImpl implements TypeService {

	EntityManager em;

	TypeDao typeDao = FactoryDaos.getTypeDao();

	private List<Type> types;

	public TypeServiceImpl() {
	}

	@Override
	public List<Type> getTypes() {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		typeDao.setEntityManager(em);
		types = typeDao.getTypes();
		em.close();
		return types;
	}

	@Override
	public Type getType(long id) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		typeDao.setEntityManager(em);
		Type type = typeDao.findById(id);
		em.close();
		return type;
	}

	@Override
	public Type newType(Type type) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		typeDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		typeDao.save(type);
		et.commit();
		em.close();
		return type;
	}

	@Override
	public Type updateType(Type type) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		typeDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		typeDao.update(type);
		et.commit();
		em.close();
		return type;
	}

	@Override
	public Type deleteType(long id) {
		Type type;
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		typeDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		type = typeDao.findById(id);
		type.setDeleted(true);
		typeDao.update(type);
		et.commit();
		em.close();
		return type;
	}

}
