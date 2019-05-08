package model;

import java.util.List;

public class Route {

	public List<RouteDonation> donations;
	public List<Message> messages;

	public Route() {
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

}
