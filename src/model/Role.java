package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Role_Type")
public abstract class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}