package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Admin;
import model.Donor;
import model.Role;
import model.User;

public class DBLoader {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persUnit");

	public DBLoader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Role role = new Admin();
		em.persist(role);
		User user = new User("name", "lastName", "username", "password", "email", role);
		em.persist(user);

		Donor role2 = new Donor();
		role2.setCompany("company");
		role2.setAddress("address");
		role2.setPhone(221354789);
		role2.setContactName("contactName");
		role2.setTime("time");
		em.persist(role2);
		User user2 = new User("name2", "lastName2", "username2", "password2", "email2", role2);
		em.persist(user2);
		et.commit();
		em.close();
	}
}