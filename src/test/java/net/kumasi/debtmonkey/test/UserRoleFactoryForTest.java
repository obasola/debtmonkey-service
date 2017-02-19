package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.UserRole;

public class UserRoleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public UserRole newUserRole() {

		Integer userAccountId = mockValues.nextInteger();
		Integer roleRoleId = mockValues.nextInteger();

		UserRole userRole = new UserRole();
		userRole.setUserAccountId(userAccountId);
		userRole.setRoleRoleId(roleRoleId);
		return userRole;
	}
	
}
