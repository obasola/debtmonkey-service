/*
 * Created on 11 Feb 2017 ( Time 18:00:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.kumasi.debtmonkey.model.AccountAddress;
import com.kumasi.debtmonkey.model.jpa.AccountAddressEntity;
import com.kumasi.debtmonkey.business.service.AccountAddressService;
import com.kumasi.debtmonkey.business.service.mapping.AccountAddressServiceMapper;
import com.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import com.kumasi.debtmonkey.persistence.services.AccountAddressPersistence;
import org.springframework.stereotype.Component;

/**
 * Implementation of AccountAddressService
 */
@Component
public class AccountAddressServiceImpl implements AccountAddressService {

	private AccountAddressPersistence accountAddressPersistence;

	@Resource
	private AccountAddressServiceMapper accountAddressServiceMapper;
	
	public AccountAddressServiceImpl() {
		accountAddressPersistence = PersistenceServiceProvider.getService(AccountAddressPersistence.class);
	}
		
	@Override
	public AccountAddress findById(Integer id) {
		AccountAddressEntity entity = accountAddressPersistence.load(id);
		return accountAddressServiceMapper.mapAccountAddressEntityToAccountAddress(entity);
	}

	@Override
	public List<AccountAddress> findAll() {
		List<AccountAddressEntity> entities = accountAddressPersistence.loadAll();
		List<AccountAddress> beans = new ArrayList<AccountAddress>();
		for(AccountAddressEntity entity : entities) {
			beans.add(accountAddressServiceMapper.mapAccountAddressEntityToAccountAddress(entity));
		}
		return beans;
	}

	@Override
	public AccountAddress save(AccountAddress accountAddress) {
		return update(accountAddress) ;
	}

	@Override
	public AccountAddress create(AccountAddress accountAddress) {
		if(accountAddressPersistence.load(accountAddress.getId()) != null) {
			throw new IllegalStateException("already.exists");
		}
		AccountAddressEntity accountAddressEntity = new AccountAddressEntity();
		accountAddressServiceMapper.mapAccountAddressToAccountAddressEntity(accountAddress, accountAddressEntity);
		AccountAddressEntity accountAddressEntitySaved = accountAddressPersistence.save(accountAddressEntity);
		return accountAddressServiceMapper.mapAccountAddressEntityToAccountAddress(accountAddressEntitySaved);
	}

	@Override
	public AccountAddress update(AccountAddress accountAddress) {
		AccountAddressEntity accountAddressEntity = accountAddressPersistence.load(accountAddress.getId());
		accountAddressServiceMapper.mapAccountAddressToAccountAddressEntity(accountAddress, accountAddressEntity);
		AccountAddressEntity accountAddressEntitySaved = accountAddressPersistence.save(accountAddressEntity);
		return accountAddressServiceMapper.mapAccountAddressEntityToAccountAddress(accountAddressEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		accountAddressPersistence.delete(id);
	}

	public AccountAddressPersistence getAccountAddressPersistence() {
		return accountAddressPersistence;
	}

	public void setAccountAddressPersistence(AccountAddressPersistence accountAddressPersistence) {
		this.accountAddressPersistence = accountAddressPersistence;
	}

	public AccountAddressServiceMapper getAccountAddressServiceMapper() {
		return accountAddressServiceMapper;
	}

	public void setAccountAddressServiceMapper(AccountAddressServiceMapper accountAddressServiceMapper) {
		this.accountAddressServiceMapper = accountAddressServiceMapper;
	}

}
