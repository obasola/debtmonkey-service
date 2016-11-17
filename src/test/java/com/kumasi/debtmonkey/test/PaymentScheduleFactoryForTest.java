package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.PaymentSchedule;

public class PaymentScheduleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentSchedule newPaymentSchedule() {

		Integer id = mockValues.nextInteger();

		PaymentSchedule paymentSchedule = new PaymentSchedule();
		paymentSchedule.setId(id);
		return paymentSchedule;
	}
	
}
