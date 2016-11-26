package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.jpa.PaymentHistoryEntity;

public class PaymentHistoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PaymentHistoryEntity newPaymentHistoryEntity() {

		Integer idpaymentHistory = mockValues.nextInteger();

		PaymentHistoryEntity paymentHistoryEntity = new PaymentHistoryEntity();
		paymentHistoryEntity.setIdpaymentHistory(idpaymentHistory);
		return paymentHistoryEntity;
	}
	
}
