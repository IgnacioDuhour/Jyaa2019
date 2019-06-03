package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String sucursal;
	public String address;
	public String location;
	public Date availableDate;
	public String availableTime;
	public boolean collected;
	public Date collectDate;
	public int collectNumber;
	@OneToMany
	@JoinColumn(name = "donation_id")
	public List<Item> items;

	public Donation() {
		this.items = new ArrayList<Item>();
	}

	public Donation(String sucursal, String address, String location, Date availableDate, String availableTime,
			boolean collected, Date collectDate, int collectNumber) {
		super();
		this.sucursal = sucursal;
		this.address = address;
		this.location = location;
		this.availableDate = availableDate;
		this.availableTime = availableTime;
		this.collected = collected;
		this.collectDate = collectDate;
		this.collectNumber = collectNumber;
		this.items = new ArrayList<Item>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	public int getCollectNumber() {
		return collectNumber;
	}

	public void setCollectNumber(int collectNumber) {
		this.collectNumber = collectNumber;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}
}
