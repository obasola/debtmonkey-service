package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.PaymentHistory;

public class PaymentHistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentHistory newPaymentHistory() {

		Integer idpaymentHistory = mockValues.nextInteger();

		PaymentHistory paymentHistory = new PaymentHistory();
		paymentHistory.setIdpaymentHistory(idpaymentHistory);
		return paymentHistory;
	}
	
}
