package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.UserAccount;

public class UserAccountFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public UserAccount newUserAccount() {

		Integer id = mockValues.nextInteger();

		UserAccount userAccount = new UserAccount();
		userAccount.setId(id);
		return userAccount;
	}
	
}
