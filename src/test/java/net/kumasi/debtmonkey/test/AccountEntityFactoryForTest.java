package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.jpa.AccountEntity;

public class AccountEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountEntity newAccountEntity() {

		Integer id = mockValues.nextInteger();

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(id);
		return accountEntity;
	}
	
}
