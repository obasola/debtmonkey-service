/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.persistence.services.fake;

import java.util.List;
import java.util.Map;

import net.kumasi.debtmonkey.domain.jpa.AccountAddressEntity;
import net.kumasi.debtmonkey.persistence.commons.fake.GenericFakeService;
import net.kumasi.debtmonkey.persistence.services.AccountAddressPersistence;

/**
 * Fake persistence service implementation ( entity "AccountAddress" )
 *
 * @author Telosys Tools Generator
 */
public class AccountAddressPersistenceFAKE extends GenericFakeService<AccountAddressEntity> implements AccountAddressPersistence {

	public AccountAddressPersistenceFAKE () {
		super(AccountAddressEntity.class);
	}
	
	protected AccountAddressEntity buildEntity(int index) {
		AccountAddressEntity entity = new AccountAddressEntity();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setAddressLine1( nextString() ) ;
		entity.setAddressLine2( nextString() ) ;
		entity.setCity( nextString() ) ;
		entity.setState( nextString() ) ;
		entity.setZipcode( nextString() ) ;
		return entity ;
	}
	
	
	public boolean delete(AccountAddressEntity entity) {
		log("delete ( AccountAddressEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(AccountAddressEntity entity) {
		log("insert ( AccountAddressEntity : " + entity + ")" ) ;
	}

	public AccountAddressEntity load( Integer id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<AccountAddressEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<AccountAddressEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<AccountAddressEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public AccountAddressEntity save(AccountAddressEntity entity) {
		log("insert ( AccountAddressEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<AccountAddressEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
