package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.ProductDao;
import dao.RoleDao;
import dao.TypeDao;
import dao.UserDao;
import factories.FactoryDaos;
import model.Admin;
import model.BankUser;
import model.Donor;
import model.Product;
import model.Role;
import model.Type;
import model.User;

/**
 * 
 * Clase para cargar y probar la base de datos
 *
 */
public class DBLoader {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persUnit");

	public DBLoader() {
	}

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		UserDao userDao = FactoryDaos.getUserDao(em);
		RoleDao roleDao = FactoryDaos.getRoleDao(em);
		TypeDao typeDao = FactoryDaos.getTypeDao(em);
		ProductDao productDao = FactoryDaos.getProductDao(em);

		// TODO mejorar el manejo del entity manager para los dao y de las
		// transacciones

		try {
			et.begin();

			System.out.println();
			System.out.println("------------------------ INSERCIONES ------------------------");
			System.out.println();
			// Nuevo administrador
			Role role = new Admin();
			roleDao.save(role);
			User user = new User("name", "lastName", "username", "password", "email", role);
			userDao.save(user);

			// Nuevo usuraio del banco
			Role role2 = new BankUser();
			roleDao.save(role2);
			User user2 = new User("name2", "lastName2", "username2", "password2", "email2", role2);
			userDao.save(user2);

			// Nuevo donante
			Donor role3 = new Donor();
			role3.setCompany("company");
			role3.setAddress("address");
			role3.setPhone(221354789);
			role3.setContactName("contactName");
			role3.setTime("time");
			User user3 = new User("name3", "lastName3", "username3", "password3", "email3", role3);
			roleDao.save(role3);
			userDao.save(user3);
			// Nuevos tipos y productos
			Type type = new Type();
			Product product = new Product();

			type.setName("Leche");
			typeDao.save(type);

			product.setBrand("La Serenisima");
			product.setSize("1 Litro");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Armonia");
			product.setSize("1 litro");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Sancor");
			product.setSize("1 Litro");
			product.setType(type);
			productDao.save(product);

			type = new Type();
			type.setName("Harina");
			typeDao.save(type);

			product = new Product();
			product.setBrand("Pureza");
			product.setSize("1 Kilo");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Cañuelas");
			product.setSize("1 Kilo");
			product.setType(type);
			productDao.save(product);

			type = new Type();
			type.setName("Yerba");
			typeDao.save(type);

			product = new Product();
			product.setBrand("Nobleza Gaucha");
			product.setSize("1 Kilo");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Nobleza Gaucha");
			product.setSize("500 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Playadito");
			product.setSize("1 Kilo");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Playadito");
			product.setSize("500 Gramos");
			product.setType(type);
			productDao.save(product);

			type = new Type();
			type.setName("Manteca");
			typeDao.save(type);

			product = new Product();
			product.setBrand("La Serenisima");
			product.setSize("100 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("La Serenisima");
			product.setSize("200 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Sancor");
			product.setSize("100 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Sancor");
			product.setSize("200 Gramos");
			product.setType(type);
			productDao.save(product);

			type = new Type();
			type.setName("Mermelada");
			typeDao.save(type);

			product = new Product();
			product.setBrand("Arcor");
			product.setSize("500 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("La Campañola");
			product.setSize("500 Gramos");
			product.setType(type);
			productDao.save(product);

			type = new Type();
			type.setName("Tomates");
			typeDao.save(type);

			product = new Product();
			product.setBrand("Arcor");
			product.setSize("400 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("Marolio");
			product.setSize("400 Gramos");
			product.setType(type);
			productDao.save(product);

			product = new Product();
			product.setBrand("La Campañola");
			product.setSize("400 Gramos");
			product.setType(type);
			productDao.save(product);

			// Nuevas donaciones
			// Nueva donacion a retirar
			// Nuevo Recorrido
			/*
			 * System.out.println(role.getId() + " " +
			 * role.getClass().getSimpleName()); System.out.println(user.getId()
			 * + " " + user.getName());
			 * 
			 * System.out.println(role3.getId() + " " +
			 * role3.getClass().getSimpleName());
			 * System.out.println(user3.getId() + " " + user3.getName());
			 */

			/*
			 * em.persist(role2); em.persist(user2);
			 */
			et.commit();

			System.out.println();
			System.out.println("------------------------ RECUPERACIONES ------------------------");
			System.out.println();
			user3 = userDao.findById(1);
			System.out.println(user3.getRole().getId() + " " + user3.getRole().getClass().getSimpleName());
			System.out.println(user3.getId() + " " + user3.getName());

			em.close();
			System.out.println();
			System.out.println("------------------------ LISTO ------------------------");
			System.out.println();
			System.out.println("------------------------ FINNN ------------------------");
			System.out.println();
		} catch (Exception e) {
			et.rollback();
			System.out.println("------------------------ ERROR!! ------------------------");
			e.printStackTrace();
		}
	}
}