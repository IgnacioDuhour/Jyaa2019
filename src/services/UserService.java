package services;

import java.util.List;

import model.User;

public interface UserService {

	public List<User> getUsers(int page, int size);

	public User getUser(long id);

	public User getUserByUsername(String username);

	public User newUser(User user);

	public User updateUser(User user);

	public User deleteUser(long id);

	public List<User> getBankUsers(int page, int size);

	public List<User> getDonorUsers(int page, int size);
}
