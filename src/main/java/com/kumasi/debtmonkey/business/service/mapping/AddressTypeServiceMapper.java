/*
 * Created on 6 Sep 2016 ( Time 17:16:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.kumasi.debtmonkey.model.AddressType;
import com.kumasi.debtmonkey.model.jpa.AddressTypeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AddressTypeServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AddressTypeServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AddressTypeEntity' to 'AddressType'
	 * @param addressTypeEntity
	 */
	public AddressType mapAddressTypeEntityToAddressType(AddressTypeEntity addressTypeEntity) {
		if(addressTypeEntity == null) {
			return null;
		}

		//--- Generic mapping 
		AddressType addressType = map(addressTypeEntity, AddressType.class);

		return addressType;
	}
	
	/**
	 * Mapping from 'AddressType' to 'AddressTypeEntity'
	 * @param addressType
	 * @param addressTypeEntity
	 */
	public void mapAddressTypeToAddressTypeEntity(AddressType addressType, AddressTypeEntity addressTypeEntity) {
		if(addressType == null) {
			return;
		}

		//--- Generic mapping 
		map(addressType, addressTypeEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}