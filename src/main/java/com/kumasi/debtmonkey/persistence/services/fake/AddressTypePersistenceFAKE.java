/*
 * Created on 6 Sep 2016 ( Time 17:16:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.persistence.services.fake;

import java.util.List;
import java.util.Map;

import com.kumasi.debtmonkey.model.jpa.AddressTypeEntity;
import com.kumasi.debtmonkey.persistence.commons.fake.GenericFakeService;
import com.kumasi.debtmonkey.persistence.services.AddressTypePersistence;

/**
 * Fake persistence service implementation ( entity "AddressType" )
 *
 * @author Telosys Tools Generator
 */
public class AddressTypePersistenceFAKE extends GenericFakeService<AddressTypeEntity> implements AddressTypePersistence {

	public AddressTypePersistenceFAKE () {
		super(AddressTypeEntity.class);
	}
	
	protected AddressTypeEntity buildEntity(int index) {
		AddressTypeEntity entity = new AddressTypeEntity();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setAddressCode( nextString() ) ;
		return entity ;
	}
	
	
	public boolean delete(AddressTypeEntity entity) {
		log("delete ( AddressTypeEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(AddressTypeEntity entity) {
		log("insert ( AddressTypeEntity : " + entity + ")" ) ;
	}

	public AddressTypeEntity load( Integer id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<AddressTypeEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<AddressTypeEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<AddressTypeEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public AddressTypeEntity save(AddressTypeEntity entity) {
		log("insert ( AddressTypeEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<AddressTypeEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
