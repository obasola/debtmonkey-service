/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.web.listitem;

import net.kumasi.debtmonkey.domain.UserRole;
import net.kumasi.debtmonkey.web.common.ListItem;

public class UserRoleListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public UserRoleListItem(UserRole userRole) {
		super();

		this.value = ""
			 + userRole.getUserAccountId()
			 + "|"  + userRole.getRoleRoleId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = userRole.getUserAccountId().toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}