
/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.mock;

import java.util.LinkedList;
import java.util.List;

import net.kumasi.debtmonkey.domain.jpa.AccountEntity;
import net.kumasi.debtmonkey.mock.tool.MockValues;

public class AccountEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public AccountEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public AccountEntity createInstance( Integer id ) {
		AccountEntity entity = new AccountEntity();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setAccountName( mockValues.nextString(45) ) ; // java.lang.String 
		entity.setOriginalBalance( mockValues.nextDouble() ) ; // java.lang.Double 
		entity.setCurrentBalance( mockValues.nextDouble() ) ; // java.lang.Double 
		entity.setDateLastPayment( mockValues.nextDate() ) ; // java.util.Date 
		entity.setDateOpened( mockValues.nextDate() ) ; // java.util.Date 
		entity.setDateClosed( mockValues.nextDate() ) ; // java.util.Date 
		entity.setDateCreated( mockValues.nextDate() ) ; // java.util.Date 
		entity.setDateModified( mockValues.nextDate() ) ; // java.util.Date 
		entity.setAutoPayment( mockValues.nextByte() ) ; // java.lang.Byte 
		// Init Link fields (if any)
		// setListOfPaymentHistory( TODO ) ; // List<PaymentHistory> 
		// setAccountAddress( TODO ) ; // AccountAddress 
		// setUserAccount( TODO ) ; // UserAccount 
		// setListOfPaymentSchedule( TODO ) ; // List<PaymentSchedule> 
		// setAccountType( TODO ) ; // AccountType 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<AccountEntity> createList(int count) {
		List<AccountEntity> list = new LinkedList<AccountEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
