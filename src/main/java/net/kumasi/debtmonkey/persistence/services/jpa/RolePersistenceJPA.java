/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package net.kumasi.debtmonkey.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import net.kumasi.debtmonkey.domain.jpa.RoleEntity;
import net.kumasi.debtmonkey.persistence.commons.jpa.GenericJpaService;
import net.kumasi.debtmonkey.persistence.commons.jpa.JpaOperation;
import net.kumasi.debtmonkey.persistence.services.RolePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Role" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class RolePersistenceJPA extends GenericJpaService<RoleEntity, Integer> implements RolePersistence {

	/**
	 * Constructor
	 */
	public RolePersistenceJPA() {
		super(RoleEntity.class);
	}

	@Override
	public RoleEntity load( Integer roleId ) {
		return super.load( roleId );
	}

	@Override
	public boolean delete( Integer roleId ) {
		return super.delete( roleId );
	}

	@Override
	public boolean delete(RoleEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getRoleId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("RoleEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
