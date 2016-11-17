/*
 * Created on 6 Sep 2016 ( Time 17:16:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.test.persistence;


import com.kumasi.debtmonkey.model.jpa.AccountAddressEntity;
import com.kumasi.debtmonkey.mock.AccountAddressEntityMock;
import com.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import com.kumasi.debtmonkey.persistence.services.AccountAddressPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for AccountAddress persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class AccountAddressPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		AccountAddressPersistence service = PersistenceServiceProvider.getService(AccountAddressPersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test AccountAddress persistence : delete + load ..." );
		
		AccountAddressPersistence service = PersistenceServiceProvider.getService(AccountAddressPersistence.class);
		
		AccountAddressEntityMock mock = new AccountAddressEntityMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0  );
		// process( service, mock, ... );
	}

	private void process(AccountAddressPersistence service, AccountAddressEntityMock mock, Integer id ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		AccountAddressEntity entity = service.load( id );
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
			// . AccountType
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