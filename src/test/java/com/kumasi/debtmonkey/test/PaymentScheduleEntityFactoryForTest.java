package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.jpa.PaymentScheduleEntity;

public class PaymentScheduleEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentScheduleEntity newPaymentScheduleEntity() {

		Integer id = mockValues.nextInteger();

		PaymentScheduleEntity paymentScheduleEntity = new PaymentScheduleEntity();
		paymentScheduleEntity.setId(id);
		return paymentScheduleEntity;
	}
	
}
