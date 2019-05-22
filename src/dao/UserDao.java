package dao;

import java.util.List;

import model.User;

public interface UserDao extends GenericDao<User> {

	public List<User> getUsers();
}
