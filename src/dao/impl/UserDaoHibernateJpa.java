package dao.impl;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaoHibernateJpa extends GenericDaoHibernateJpa<User> implements UserDao {

	public UserDaoHibernateJpa() {
		super(User.class);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
