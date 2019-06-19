package dao;

import java.util.List;

import model.Donor;
import model.User;

public interface DonorDao extends GenericDao<Donor> {
	public List<User> getDonorUsers(int page, int size);
}
