package factories;

import dao.UserDao;
import dao.impl.UserDaoHibernateJpa;

public class FactoryDaos {
	
	static public UserDao getUserDao() {
		return new UserDaoHibernateJpa();
	}
}
