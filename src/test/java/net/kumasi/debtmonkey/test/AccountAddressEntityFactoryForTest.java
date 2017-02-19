package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.jpa.AccountAddressEntity;

public class AccountAddressEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountAddressEntity newAccountAddressEntity() {

		Integer id = mockValues.nextInteger();

		AccountAddressEntity accountAddressEntity = new AccountAddressEntity();
		accountAddressEntity.setId(id);
		return accountAddressEntity;
	}
	
}
