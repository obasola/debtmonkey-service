package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.AccountType;

public class AccountTypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountType newAccountType() {

		Integer id = mockValues.nextInteger();

		AccountType accountType = new AccountType();
		accountType.setId(id);
		return accountType;
	}
	
}
