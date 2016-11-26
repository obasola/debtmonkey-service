/*
 * Created on 23 Nov 2016 ( Time 14:35:14 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.persistence.services.fake;

import java.util.List;
import java.util.Map;

import com.kumasi.debtmonkey.model.jpa.PaymentHistoryEntity;
import com.kumasi.debtmonkey.persistence.commons.fake.GenericFakeService;
import com.kumasi.debtmonkey.persistence.services.PaymentHistoryPersistence;

/**
 * Fake persistence service implementation ( entity "PaymentHistory" )
 *
 * @author Telosys Tools Generator
 */
public class PaymentHistoryPersistenceFAKE extends GenericFakeService<PaymentHistoryEntity> implements PaymentHistoryPersistence {

	public PaymentHistoryPersistenceFAKE () {
		super(PaymentHistoryEntity.class);
	}
	
	protected PaymentHistoryEntity buildEntity(int index) {
		PaymentHistoryEntity entity = new PaymentHistoryEntity();
		// Init fields with mock values
		entity.setIdpaymentHistory( nextInteger() ) ;
		entity.setAmountPaid( nextDouble() ) ;
		entity.setDatePaid( nextDate() ) ;
		entity.setDateModified( nextDate() ) ;
		entity.setDateCreated( nextDate() ) ;
		return entity ;
	}
	
	
	public boolean delete(PaymentHistoryEntity entity) {
		log("delete ( PaymentHistoryEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer idpaymentHistory ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(PaymentHistoryEntity entity) {
		log("insert ( PaymentHistoryEntity : " + entity + ")" ) ;
	}

	public PaymentHistoryEntity load( Integer idpaymentHistory ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<PaymentHistoryEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<PaymentHistoryEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<PaymentHistoryEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public PaymentHistoryEntity save(PaymentHistoryEntity entity) {
		log("insert ( PaymentHistoryEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<PaymentHistoryEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}