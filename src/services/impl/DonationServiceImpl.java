package services.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.DonationDao;
import factories.FactoryDaos;
import model.Donation;
import services.DonationService;

public class DonationServiceImpl implements DonationService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persUnit");
	EntityManager em = emf.createEntityManager();

	DonationDao donationDao = FactoryDaos.getDonationDao(em);

	public DonationServiceImpl() {
	}

	@Override
	public List<Donation> getDonations(int page, int size) {
		return donationDao.getDonations(page, size);
	}

	@Override
	public Donation getDonation(long id) {
		return donationDao.findById(id);
	}

	@Override
	public Donation markCollected(long id, int collectNumber, Date collectDate) {
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

}
