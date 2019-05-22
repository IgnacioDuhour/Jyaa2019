package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RouteDonation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public Date collectDate;
	public String collectTime;
	@OneToOne
	@JoinColumn(name = "donation_id", nullable = false)
	public Donation donation;

	public RouteDonation() {
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

}
