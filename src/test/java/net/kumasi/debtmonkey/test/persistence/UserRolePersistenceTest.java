/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.test.persistence;


import net.kumasi.debtmonkey.domain.jpa.UserRoleEntity;
import net.kumasi.debtmonkey.mock.UserRoleEntityMock;
import net.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import net.kumasi.debtmonkey.persistence.services.UserRolePersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for UserRole persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class UserRolePersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		UserRolePersistence service = PersistenceServiceProvider.getService(UserRolePersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test UserRole persistence : delete + load ..." );
		
		UserRolePersistence service = PersistenceServiceProvider.getService(UserRolePersistence.class);
		
		UserRoleEntityMock mock = new UserRoleEntityMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0 , 0  );
		// process( service, mock, ... );
	}

	private void process(UserRolePersistence service, UserRoleEntityMock mock, Integer userAccountId, Integer roleRoleId ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		UserRoleEntity entity = service.load( userAccountId, roleRoleId );
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
			entity = mock.createInstance( userAccountId, roleRoleId ) ;
			Assert.assertNotNull(entity);

			/* NB : this entity is a "Join Table" 
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );
			*/

			System.out.println(" . delete : " );
			boolean deleted = service.delete( userAccountId, roleRoleId );
			System.out.println("   deleted = " + deleted);
		}		
	}
}
