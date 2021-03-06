/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package net.kumasi.debtmonkey.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import net.kumasi.debtmonkey.domain.jpa.PaymentScheduleEntity;
import net.kumasi.debtmonkey.persistence.commons.jpa.GenericJpaService;
import net.kumasi.debtmonkey.persistence.commons.jpa.JpaOperation;
import net.kumasi.debtmonkey.persistence.services.PaymentSchedulePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "PaymentSchedule" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class PaymentSchedulePersistenceJPA extends GenericJpaService<PaymentScheduleEntity, Integer> implements PaymentSchedulePersistence {

	/**
	 * Constructor
	 */
	public PaymentSchedulePersistenceJPA() {
		super(PaymentScheduleEntity.class);
	}

	@Override
	public PaymentScheduleEntity load( Integer id ) {
		return super.load( id );
	}

	@Override
	public boolean delete( Integer id ) {
		return super.delete( id );
	}

	@Override
	public boolean delete(PaymentScheduleEntity entity) {
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
				Query query = em.createNamedQuery("PaymentScheduleEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
