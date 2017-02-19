package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.jpa.UserRoleEntity;

public class UserRoleEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public UserRoleEntity newUserRoleEntity() {

		Integer userAccountId = mockValues.nextInteger();
		Integer roleRoleId = mockValues.nextInteger();

		UserRoleEntity userRoleEntity = new UserRoleEntity();
		userRoleEntity.setUserAccountId(userAccountId);
		userRoleEntity.setRoleRoleId(roleRoleId);
		return userRoleEntity;
	}
	
}
