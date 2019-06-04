package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	@OneToMany
	@JoinColumn(name = "route_id")
	public List<RouteDonation> donations;
	@OneToMany
	@JoinColumn(name = "route_id")
	public List<Message> messages;

	public Route() {
		this.donations = new ArrayList<RouteDonation>();
		this.messages = new ArrayList<Message>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<RouteDonation> getDonations() {
		return donations;
	}

	public void setDonations(List<RouteDonation> donations) {
		this.donations = donations;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void addDonation(RouteDonation donation) {
		this.donations.add(donation);
	}

	public void addMessage(Message message) {
		this.messages.add(message);
	}
}
