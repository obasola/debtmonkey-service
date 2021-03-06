/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.web.listitem;

import net.kumasi.debtmonkey.domain.Account;
import net.kumasi.debtmonkey.web.common.ListItem;

public class AccountListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public AccountListItem(Account account) {
		super();

		this.value = ""
			 + account.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = account.getAccountName();
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
