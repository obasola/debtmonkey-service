/*
 * Created on 6 Sep 2016 ( Time 17:16:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.kumasi.debtmonkey.model.AddressType;
import com.kumasi.debtmonkey.model.jpa.AddressTypeEntity;
import com.kumasi.debtmonkey.business.service.AddressTypeService;
import com.kumasi.debtmonkey.business.service.mapping.AddressTypeServiceMapper;
import com.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import com.kumasi.debtmonkey.persistence.services.AddressTypePersistence;
import org.springframework.stereotype.Component;

/**
 * Implementation of AddressTypeService
 */
@Component
public class AddressTypeServiceImpl implements AddressTypeService {

	private AddressTypePersistence addressTypePersistence;

	@Resource
	private AddressTypeServiceMapper addressTypeServiceMapper;
	
	public AddressTypeServiceImpl() {
		addressTypePersistence = PersistenceServiceProvider.getService(AddressTypePersistence.class);
	}
		
	@Override
	public AddressType findById(Integer id) {
		AddressTypeEntity entity = addressTypePersistence.load(id);
		return addressTypeServiceMapper.mapAddressTypeEntityToAddressType(entity);
	}

	@Override
	public List<AddressType> findAll() {
		List<AddressTypeEntity> entities = addressTypePersistence.loadAll();
		List<AddressType> beans = new ArrayList<AddressType>();
		for(AddressTypeEntity entity : entities) {
			beans.add(addressTypeServiceMapper.mapAddressTypeEntityToAddressType(entity));
		}
		return beans;
	}

	@Override
	public AddressType save(AddressType addressType) {
		return update(addressType) ;
	}

	@Override
	public AddressType create(AddressType addressType) {
		/*
		if(addressTypePersistence.load(addressType.getId()) != null) {
			throw new IllegalStateException("already.exists");
		}
		*/
		AddressTypeEntity addressTypeEntity = new AddressTypeEntity();
		addressTypeServiceMapper.mapAddressTypeToAddressTypeEntity(addressType, addressTypeEntity);
		AddressTypeEntity addressTypeEntitySaved = addressTypePersistence.save(addressTypeEntity);
		return addressTypeServiceMapper.mapAddressTypeEntityToAddressType(addressTypeEntitySaved);
	}

	@Override
	public AddressType update(AddressType addressType) {
		AddressTypeEntity addressTypeEntity = addressTypePersistence.load(addressType.getId());
		addressTypeServiceMapper.mapAddressTypeToAddressTypeEntity(addressType, addressTypeEntity);
		AddressTypeEntity addressTypeEntitySaved = addressTypePersistence.save(addressTypeEntity);
		return addressTypeServiceMapper.mapAddressTypeEntityToAddressType(addressTypeEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		addressTypePersistence.delete(id);
	}

	public AddressTypePersistence getAddressTypePersistence() {
		return addressTypePersistence;
	}

	public void setAddressTypePersistence(AddressTypePersistence addressTypePersistence) {
		this.addressTypePersistence = addressTypePersistence;
	}

	public AddressTypeServiceMapper getAddressTypeServiceMapper() {
		return addressTypeServiceMapper;
	}

	public void setAddressTypeServiceMapper(AddressTypeServiceMapper addressTypeServiceMapper) {
		this.addressTypeServiceMapper = addressTypeServiceMapper;
	}

}
