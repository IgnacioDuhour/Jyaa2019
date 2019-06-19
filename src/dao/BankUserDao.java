package dao;

import java.util.List;

import model.BankUser;
import model.User;

public interface BankUserDao extends GenericDao<BankUser> {
	public List<User> getBankUsers(int page, int size);
}
