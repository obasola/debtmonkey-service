
/*
 * Created on 6 Sep 2016 ( Time 17:16:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.mock;

import java.util.LinkedList;
import java.util.List;

import com.kumasi.debtmonkey.model.jpa.AccountAddressEntity;
import com.kumasi.debtmonkey.mock.tool.MockValues;

public class AccountAddressEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public AccountAddressEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public AccountAddressEntity createInstance( Integer id ) {
		AccountAddressEntity entity = new AccountAddressEntity();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setAddressLine1( mockValues.nextString(45) ) ; // java.lang.String 
		entity.setAddressLine2( mockValues.nextString(45) ) ; // java.lang.String 
		entity.setCity( mockValues.nextString(45) ) ; // java.lang.String 
		entity.setState( mockValues.nextString(45) ) ; // java.lang.String 
		entity.setZipcode( mockValues.nextString(5) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setAccount( TODO ) ; // Account 
		// setAccountType( TODO ) ; // AccountType 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<AccountAddressEntity> createList(int count) {
		List<AccountAddressEntity> list = new LinkedList<AccountAddressEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}