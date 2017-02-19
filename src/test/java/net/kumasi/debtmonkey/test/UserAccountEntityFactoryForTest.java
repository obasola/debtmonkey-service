package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.jpa.UserAccountEntity;

public class UserAccountEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public UserAccountEntity newUserAccountEntity() {

		Integer id = mockValues.nextInteger();

		UserAccountEntity userAccountEntity = new UserAccountEntity();
		userAccountEntity.setId(id);
		return userAccountEntity;
	}
	
}
