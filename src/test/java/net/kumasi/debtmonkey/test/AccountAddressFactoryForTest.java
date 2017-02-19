package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.AccountAddress;

public class AccountAddressFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountAddress newAccountAddress() {

		Integer id = mockValues.nextInteger();

		AccountAddress accountAddress = new AccountAddress();
		accountAddress.setId(id);
		return accountAddress;
	}
	
}
