package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.jpa.AccountEntity;

public class AccountEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountEntity newAccountEntity() {

		Integer id = mockValues.nextInteger();

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(id);
		return accountEntity;
	}
	
}
