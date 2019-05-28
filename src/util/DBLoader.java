package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.DonationDao;
import dao.ItemDao;
import dao.ProductDao;
import dao.RoleDao;
import dao.TypeDao;
import dao.UserDao;
import factories.FactoryDaos;
import model.Admin;
import model.BankUser;
import model.Donation;
import model.Donor;
import model.Item;
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
		DonationDao donationDao = FactoryDaos.getDonationProductDao(em);
		ItemDao itemDao = FactoryDaos.getItemDao(em);
		ProductDao productDao = FactoryDaos.getProductDao(em);
		RoleDao roleDao = FactoryDaos.getRoleDao(em);
		TypeDao typeDao = FactoryDaos.getTypeDao(em);
		UserDao userDao = FactoryDaos.getUserDao(em);

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

			Product product2 = new Product();
			product2.setBrand("Armonia");
			product2.setSize("1 litro");
			product2.setType(type);
			productDao.save(product2);

			Product product3 = new Product();
			product3.setBrand("Sancor");
			product3.setSize("1 Litro");
			product3.setType(type);
			productDao.save(product3);

			Type type2 = new Type();
			type2.setName("Harina");
			typeDao.save(type2);

			Product product4 = new Product();
			product4.setBrand("Pureza");
			product4.setSize("1 Kilo");
			product4.setType(type2);
			productDao.save(product4);

			Product product5 = new Product();
			product5.setBrand("Cañuelas");
			product5.setSize("1 Kilo");
			product5.setType(type2);
			productDao.save(product5);

			Type type3 = new Type();
			type3.setName("Yerba");
			typeDao.save(type3);

			Product product6 = new Product();
			product6.setBrand("Nobleza Gaucha");
			product6.setSize("1 Kilo");
			product6.setType(type3);
			productDao.save(product6);

			Product product7 = new Product();
			product7.setBrand("Nobleza Gaucha");
			product7.setSize("500 Gramos");
			product7.setType(type3);
			productDao.save(product7);

			Product product8 = new Product();
			product8.setBrand("Playadito");
			product8.setSize("1 Kilo");
			product8.setType(type3);
			productDao.save(product8);

			Product product9 = new Product();
			product9.setBrand("Playadito");
			product9.setSize("500 Gramos");
			product9.setType(type3);
			productDao.save(product9);

			Type type4 = new Type();
			type4.setName("Manteca");
			typeDao.save(type4);

			Product product10 = new Product();
			product10.setBrand("La Serenisima");
			product10.setSize("100 Gramos");
			product10.setType(type4);
			productDao.save(product10);

			Product product11 = new Product();
			product11.setBrand("La Serenisima");
			product11.setSize("200 Gramos");
			product11.setType(type4);
			productDao.save(product11);

			Product product12 = new Product();
			product12.setBrand("Sancor");
			product12.setSize("100 Gramos");
			product12.setType(type4);
			productDao.save(product12);

			Product product13 = new Product();
			product13.setBrand("Sancor");
			product13.setSize("200 Gramos");
			product13.setType(type4);
			productDao.save(product13);

			Type type5 = new Type();
			type5.setName("Mermelada");
			typeDao.save(type5);

			Product product14 = new Product();
			product14.setBrand("Arcor");
			product14.setSize("500 Gramos");
			product14.setType(type5);
			productDao.save(product14);

			Product product15 = new Product();
			product15.setBrand("La Campañola");
			product15.setSize("500 Gramos");
			product15.setType(type5);
			productDao.save(product15);

			Type type6 = new Type();
			type6.setName("Tomates");
			typeDao.save(type6);

			Product product16 = new Product();
			product16.setBrand("Arcor");
			product16.setSize("400 Gramos");
			product16.setType(type6);
			productDao.save(product16);

			Product product17 = new Product();
			product17.setBrand("Marolio");
			product17.setSize("400 Gramos");
			product17.setType(type6);
			productDao.save(product17);

			Product product18 = new Product();
			product18.setBrand("La Campañola");
			product18.setSize("400 Gramos");
			product18.setType(type6);
			productDao.save(product18);

			// Nuevas donaciones
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse("20/08/2019");
			Donation donation = new Donation("sucursal", "address", "location", date, "availableTime", false, date, 0);

			Item item = new Item();
			item.setExpiration(date);
			item.setProduct(product);
			item.setQuantity(25);
			itemDao.save(item);

			donation.addItem(item);

			item = new Item();
			item.setExpiration(date);
			item.setProduct(product5);
			item.setQuantity(25);
			itemDao.save(item);

			donation.addItem(item);

			item = new Item();
			item.setExpiration(date);
			item.setProduct(product14);
			item.setQuantity(25);
			itemDao.save(item);

			donation.addItem(item);
			donationDao.save(donation);

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