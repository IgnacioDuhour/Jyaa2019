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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String routeName;
	public Date collectDate;
	@OneToMany()
	@JoinColumn(name = "route_id")
	@JsonIgnore
	public List<RouteDonation> donations;
	@OneToMany
	@JoinColumn(name = "route_id")
	@JsonIgnore
	public List<Message> messages;
	public boolean deleted;

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

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	@JsonIgnore
	public List<RouteDonation> getDonations() {
		return donations;
	}

	public void setDonations(List<RouteDonation> donations) {
		this.donations = donations;
	}

	@JsonIgnore
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
