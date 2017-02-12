
/*
 * Created on 11 Feb 2017 ( Time 18:00:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.mock;

import java.util.LinkedList;
import java.util.List;

import com.kumasi.debtmonkey.model.jpa.PaymentScheduleEntity;
import com.kumasi.debtmonkey.mock.tool.MockValues;

public class PaymentScheduleEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public PaymentScheduleEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public PaymentScheduleEntity createInstance( Integer id ) {
		PaymentScheduleEntity entity = new PaymentScheduleEntity();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setNextPaymentDue( mockValues.nextDate() ) ; // java.util.Date 
		entity.setBalanceDue( mockValues.nextDouble() ) ; // java.lang.Double 
		entity.setAutoPayment( mockValues.nextByte() ) ; // java.lang.Byte 
		// Init Link fields (if any)
		// setAccount( TODO ) ; // Account 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<PaymentScheduleEntity> createList(int count) {
		List<PaymentScheduleEntity> list = new LinkedList<PaymentScheduleEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
