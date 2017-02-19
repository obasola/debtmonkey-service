
/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.mock;

import java.util.LinkedList;
import java.util.List;

import net.kumasi.debtmonkey.domain.jpa.RoleEntity;
import net.kumasi.debtmonkey.mock.tool.MockValues;

public class RoleEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public RoleEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public RoleEntity createInstance( Integer roleId ) {
		RoleEntity entity = new RoleEntity();
		// Init Primary Key fields
		entity.setRoleId( roleId) ;
		// Init Data fields
		entity.setRoleName( mockValues.nextString(255) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setListOfUserAccount( TODO ) ; // List<UserAccount> 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<RoleEntity> createList(int count) {
		List<RoleEntity> list = new LinkedList<RoleEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}