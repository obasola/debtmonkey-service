package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.Account;

public class AccountFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Account newAccount() {

		Integer id = mockValues.nextInteger();

		Account account = new Account();
		account.setId(id);
		return account;
	}
	
}
