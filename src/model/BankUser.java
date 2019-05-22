package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bank_User")
public class BankUser extends Role {

	public BankUser() {
	}

}
