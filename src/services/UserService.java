package services;

import java.util.List;

import model.User;

public interface UserService {

	public List<User> getUsers(int page, int size);

	public User getUser(long id);

	public User newUser(User user);

	public User updateUser(User user);

	public User deletUser(long id);
}
