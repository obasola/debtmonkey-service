package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.AccountAddress;

public class AccountAddressFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountAddress newAccountAddress() {

		Integer id = mockValues.nextInteger();

		AccountAddress accountAddress = new AccountAddress();
		accountAddress.setId(id);
		return accountAddress;
	}
	
}
