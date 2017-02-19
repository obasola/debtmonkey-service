package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.Account;

public class AccountFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Account newAccount() {

		Integer id = mockValues.nextInteger();

		Account account = new Account();
		account.setId(id);
		return account;
	}
	
}
