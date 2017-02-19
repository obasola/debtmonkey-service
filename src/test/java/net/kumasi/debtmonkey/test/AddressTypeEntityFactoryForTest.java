package net.kumasi.debtmonkey.test;

import net.kumasi.debtmonkey.domain.jpa.AddressTypeEntity;

public class AddressTypeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public AddressTypeEntity newAddressTypeEntity() {

		Integer id = mockValues.nextInteger();

		AddressTypeEntity addressTypeEntity = new AddressTypeEntity();
		addressTypeEntity.setId(id);
		return addressTypeEntity;
	}
	
}
