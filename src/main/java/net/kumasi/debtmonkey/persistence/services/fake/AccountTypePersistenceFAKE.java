/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.persistence.services.fake;

import java.util.List;
import java.util.Map;

import net.kumasi.debtmonkey.domain.jpa.AccountTypeEntity;
import net.kumasi.debtmonkey.persistence.commons.fake.GenericFakeService;
import net.kumasi.debtmonkey.persistence.services.AccountTypePersistence;

/**
 * Fake persistence service implementation ( entity "AccountType" )
 *
 * @author Telosys Tools Generator
 */
public class AccountTypePersistenceFAKE extends GenericFakeService<AccountTypeEntity> implements AccountTypePersistence {

	public AccountTypePersistenceFAKE () {
		super(AccountTypeEntity.class);
	}
	
	protected AccountTypeEntity buildEntity(int index) {
		AccountTypeEntity entity = new AccountTypeEntity();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setAccountCode( nextString() ) ;
		entity.setAccountName( nextString() ) ;
		return entity ;
	}
	
	
	public boolean delete(AccountTypeEntity entity) {
		log("delete ( AccountTypeEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(AccountTypeEntity entity) {
		log("insert ( AccountTypeEntity : " + entity + ")" ) ;
	}

	public AccountTypeEntity load( Integer id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<AccountTypeEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<AccountTypeEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<AccountTypeEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public AccountTypeEntity save(AccountTypeEntity entity) {
		log("insert ( AccountTypeEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<AccountTypeEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
