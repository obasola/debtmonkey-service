/*
 * Created on 11 Feb 2017 ( Time 18:00:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package com.kumasi.debtmonkey.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.kumasi.debtmonkey.model.jpa.AccountTypeEntity;
import com.kumasi.debtmonkey.persistence.commons.jpa.GenericJpaService;
import com.kumasi.debtmonkey.persistence.commons.jpa.JpaOperation;
import com.kumasi.debtmonkey.persistence.services.AccountTypePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "AccountType" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class AccountTypePersistenceJPA extends GenericJpaService<AccountTypeEntity, Integer> implements AccountTypePersistence {

	/**
	 * Constructor
	 */
	public AccountTypePersistenceJPA() {
		super(AccountTypeEntity.class);
	}

	@Override
	public AccountTypeEntity load( Integer id ) {
		return super.load( id );
	}

	@Override
	public boolean delete( Integer id ) {
		return super.delete( id );
	}

	@Override
	public boolean delete(AccountTypeEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("AccountTypeEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
