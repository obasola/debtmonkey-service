package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.AccountType;

public class AccountTypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountType newAccountType() {

		Integer id = mockValues.nextInteger();

		AccountType accountType = new AccountType();
		accountType.setId(id);
		return accountType;
	}
	
}
