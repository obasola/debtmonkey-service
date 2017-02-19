/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.persistence.services.fake;

import java.util.List;
import java.util.Map;

import net.kumasi.debtmonkey.domain.jpa.AccountEntity;
import net.kumasi.debtmonkey.persistence.commons.fake.GenericFakeService;
import net.kumasi.debtmonkey.persistence.services.AccountPersistence;

/**
 * Fake persistence service implementation ( entity "Account" )
 *
 * @author Telosys Tools Generator
 */
public class AccountPersistenceFAKE extends GenericFakeService<AccountEntity> implements AccountPersistence {

	public AccountPersistenceFAKE () {
		super(AccountEntity.class);
	}
	
	protected AccountEntity buildEntity(int index) {
		AccountEntity entity = new AccountEntity();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setAccountName( nextString() ) ;
		entity.setOriginalBalance( nextDouble() ) ;
		entity.setCurrentBalance( nextDouble() ) ;
		entity.setDateLastPayment( nextDate() ) ;
		entity.setDateOpened( nextDate() ) ;
		entity.setDateClosed( nextDate() ) ;
		entity.setDateCreated( nextDate() ) ;
		entity.setDateModified( nextDate() ) ;
		entity.setAutoPayment( nextByte() ) ;
		return entity ;
	}
	
	
	public boolean delete(AccountEntity entity) {
		log("delete ( AccountEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(AccountEntity entity) {
		log("insert ( AccountEntity : " + entity + ")" ) ;
	}

	public AccountEntity load( Integer id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<AccountEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<AccountEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<AccountEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public AccountEntity save(AccountEntity entity) {
		log("insert ( AccountEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<AccountEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}