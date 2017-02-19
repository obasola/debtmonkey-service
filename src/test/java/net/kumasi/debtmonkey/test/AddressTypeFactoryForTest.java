package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.AddressType;

public class AddressTypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AddressType newAddressType() {

		Integer id = mockValues.nextInteger();

		AddressType addressType = new AddressType();
		addressType.setId(id);
		return addressType;
	}
	
}
