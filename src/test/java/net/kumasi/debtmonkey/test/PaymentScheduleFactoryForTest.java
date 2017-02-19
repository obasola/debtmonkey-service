package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.PaymentSchedule;

public class PaymentScheduleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentSchedule newPaymentSchedule() {

		Integer id = mockValues.nextInteger();

		PaymentSchedule paymentSchedule = new PaymentSchedule();
		paymentSchedule.setId(id);
		return paymentSchedule;
	}
	
}
