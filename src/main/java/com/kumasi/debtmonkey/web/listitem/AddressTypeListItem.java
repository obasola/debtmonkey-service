/*
 * Created on 6 Sep 2016 ( Time 17:16:57 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.web.listitem;

import com.kumasi.debtmonkey.model.AddressType;
import com.kumasi.debtmonkey.web.common.ListItem;

public class AddressTypeListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public AddressTypeListItem(AddressType addressType) {
		super();

		this.value = ""
			 + addressType.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = addressType.toString();
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