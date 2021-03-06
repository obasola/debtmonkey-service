/*
 * Created on 17 Feb 2017 ( Time 16:36:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.kumasi.debtmonkey.domain.AddressType;
import net.kumasi.debtmonkey.domain.jpa.AddressTypeEntity;

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