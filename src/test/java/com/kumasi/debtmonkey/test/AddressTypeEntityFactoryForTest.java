package com.kumasi.debtmonkey.test;

import com.kumasi.debtmonkey.model.jpa.AddressTypeEntity;

public class AddressTypeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AddressTypeEntity newAddressTypeEntity() {

		Integer id = mockValues.nextInteger();

		AddressTypeEntity addressTypeEntity = new AddressTypeEntity();
		addressTypeEntity.setId(id);
		return addressTypeEntity;
	}
	
}
