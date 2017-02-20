package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.Role;
import net.kumasi.debtmonkey.domain.UserAccount;
import net.kumasi.debtmonkey.domain.UserRole;

public class UserRoleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public UserRole newUserRole() {

		Integer userAccountId = mockValues.nextInteger();
		Integer roleRoleId = mockValues.nextInteger();

		UserRole userRole = new UserRole();
		userRole.setRole(new Role());
		userRole.setUserAccount(new UserAccount());
		userRole.getUserAccount().setId(userAccountId);
		userRole.getRole().setRoleId(roleRoleId);
		return userRole;
	}
	
}
