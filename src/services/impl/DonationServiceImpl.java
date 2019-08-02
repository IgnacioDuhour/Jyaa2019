package services.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.DonationDao;
import dao.ItemDao;
import factories.FactoryDaos;
import model.Donation;
import model.Item;
import services.DonationService;

public class DonationServiceImpl implements DonationService {

	EntityManager em;

	DonationDao donationDao = FactoryDaos.getDonationDao();
	ItemDao itemDao = FactoryDaos.getItemDao();

	private List<Donation> donations;

	public DonationServiceImpl() {
	}

	@Override
	public List<Donation> getDonations(int page, int size) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		donationDao.setEntityManager(em);
		donations = donationDao.getDonations(page, size);
		for (Donation donation : donations) {
			donation.setItemsSize(donation.getItems().size());
		}
		em.close();
		return donations;
	}

	@Override
	public Donation getDonation(long id) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		donationDao.setEntityManager(em);
		Donation donation = donationDao.findById(id);
		em.close();
		return donation;
	}

	@Override
	public Donation markCollected(long id, int collectNumber, Date collectDate) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		donationDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		Donation donation = donationDao.findById(id);
		donation.setCollected(true);
		donation.setCollectNumber(collectNumber);
		donation.setCollectDate(collectDate);
		donationDao.update(donation);
		et.commit();
		return donation;
	}

	@Override
	public List<Item> getDonationItems(long id) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		itemDao.setEntityManager(em);
		List<Item> items = itemDao.getItems(id);
		em.close();
		return items;
	}

}
