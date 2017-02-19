package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.jpa.PaymentScheduleEntity;

public class PaymentScheduleEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentScheduleEntity newPaymentScheduleEntity() {

		Integer id = mockValues.nextInteger();

		PaymentScheduleEntity paymentScheduleEntity = new PaymentScheduleEntity();
		paymentScheduleEntity.setId(id);
		return paymentScheduleEntity;
	}
	
}
