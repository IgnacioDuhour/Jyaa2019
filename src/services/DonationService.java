package services;

import java.util.Date;
import java.util.List;

import model.Donation;
import model.Item;

public interface DonationService {

	public List<Donation> getDonations(int page, int size);

	public Donation getDonation(long id);

	public Donation markCollected(long id, int collectNumber, Date collectDate);

	public List<Item> getDonationItems(long id);
}
