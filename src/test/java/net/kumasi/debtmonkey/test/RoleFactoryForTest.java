package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.Role;

public class RoleFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Role newRole() {

		Integer roleId = mockValues.nextInteger();

		Role role = new Role();
		role.setRoleId(roleId);
		return role;
	}
	
}
