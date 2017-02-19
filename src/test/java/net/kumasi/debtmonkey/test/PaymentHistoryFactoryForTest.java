package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.PaymentHistory;

public class PaymentHistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentHistory newPaymentHistory() {

		Integer idpaymentHistory = mockValues.nextInteger();

		PaymentHistory paymentHistory = new PaymentHistory();
		paymentHistory.setIdpaymentHistory(idpaymentHistory);
		return paymentHistory;
	}
	
}
