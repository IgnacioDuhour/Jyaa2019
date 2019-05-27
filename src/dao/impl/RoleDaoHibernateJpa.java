package dao.impl;

import javax.persistence.EntityManager;

import dao.RoleDao;
import model.Role;

/**
 * 
 * Implementacion Jpa Hibernate del Dao de Roles de Usuario
 *
 */
public class RoleDaoHibernateJpa extends GenericDaoHibernateJpa<Role> implements RoleDao {

	public RoleDaoHibernateJpa() {
		super(Role.class);
	}

	public RoleDaoHibernateJpa(EntityManager em) {
		super(Role.class);
		this.setEntityManager(em);
	}

}
