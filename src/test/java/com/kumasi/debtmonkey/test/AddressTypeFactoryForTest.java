package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.AddressType;

public class AddressTypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AddressType newAddressType() {

		Integer id = mockValues.nextInteger();

		AddressType addressType = new AddressType();
		addressType.setId(id);
		return addressType;
	}
	
}
