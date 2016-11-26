/*
 * Created on 24 Nov 2016 ( Time 14:55:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.test.persistence;


import com.kumasi.debtmonkey.model.jpa.PaymentScheduleEntity;
import com.kumasi.debtmonkey.mock.PaymentScheduleEntityMock;
import com.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import com.kumasi.debtmonkey.persistence.services.PaymentSchedulePersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for PaymentSchedule persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class PaymentSchedulePersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		PaymentSchedulePersistence service = PersistenceServiceProvider.getService(PaymentSchedulePersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test PaymentSchedule persistence : delete + load ..." );
		
		PaymentSchedulePersistence service = PersistenceServiceProvider.getService(PaymentSchedulePersistence.class);
		
		PaymentScheduleEntityMock mock = new PaymentScheduleEntityMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0  );
		// process( service, mock, ... );
	}

	private void process(PaymentSchedulePersistence service, PaymentScheduleEntityMock mock, Integer id ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		PaymentScheduleEntity entity = service.load( id );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( id ) ;
			Assert.assertNotNull(entity);

			// This entity references the following entities : 
			// . Account
			/* Insert only if references are OK
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );
			*/

			System.out.println(" . delete : " );
			boolean deleted = service.delete( id );
			System.out.println("   deleted = " + deleted);
		}		
	}
}
