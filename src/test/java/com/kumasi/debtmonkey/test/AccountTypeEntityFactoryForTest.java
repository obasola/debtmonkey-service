package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.jpa.AccountTypeEntity;

public class AccountTypeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AccountTypeEntity newAccountTypeEntity() {

		Integer id = mockValues.nextInteger();

		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setId(id);
		return accountTypeEntity;
	}
	
}
