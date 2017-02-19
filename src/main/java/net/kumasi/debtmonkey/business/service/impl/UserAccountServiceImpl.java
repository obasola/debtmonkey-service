/*
 * Created on 17 Feb 2017 ( Time 16:36:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.kumasi.debtmonkey.domain.UserAccount;
import net.kumasi.debtmonkey.domain.jpa.UserAccountEntity;
import java.util.List;
import net.kumasi.debtmonkey.business.service.UserAccountService;
import net.kumasi.debtmonkey.business.service.mapping.UserAccountServiceMapper;
import net.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import net.kumasi.debtmonkey.persistence.services.UserAccountPersistence;
import org.springframework.stereotype.Component;

/**
 * Implementation of UserAccountService
 */
@Component
public class UserAccountServiceImpl implements UserAccountService {

	private UserAccountPersistence userAccountPersistence;

	@Resource
	private UserAccountServiceMapper userAccountServiceMapper;
	
	public UserAccountServiceImpl() {
		userAccountPersistence = PersistenceServiceProvider.getService(UserAccountPersistence.class);
	}
		
	@Override
	public UserAccount findById(Integer id) {
		UserAccountEntity entity = userAccountPersistence.load(id);
		return userAccountServiceMapper.mapUserAccountEntityToUserAccount(entity);
	}

	@Override
	public List<UserAccount> findAll() {
		List<UserAccountEntity> entities = userAccountPersistence.loadAll();
		List<UserAccount> beans = new ArrayList<UserAccount>();
		for(UserAccountEntity entity : entities) {
			beans.add(userAccountServiceMapper.mapUserAccountEntityToUserAccount(entity));
		}
		return beans;
	}

	@Override
	public UserAccount save(UserAccount userAccount) {
		return update(userAccount) ;
	}

	@Override
	public UserAccount create(UserAccount userAccount) {
		if(userAccountPersistence.load(userAccount.getId()) != null) {
			throw new IllegalStateException("already.exists");
		}
		UserAccountEntity userAccountEntity = new UserAccountEntity();
		userAccountServiceMapper.mapUserAccountToUserAccountEntity(userAccount, userAccountEntity);
		UserAccountEntity userAccountEntitySaved = userAccountPersistence.save(userAccountEntity);
		return userAccountServiceMapper.mapUserAccountEntityToUserAccount(userAccountEntitySaved);
	}

	@Override
	public UserAccount update(UserAccount userAccount) {
		UserAccountEntity userAccountEntity = userAccountPersistence.load(userAccount.getId());
		userAccountServiceMapper.mapUserAccountToUserAccountEntity(userAccount, userAccountEntity);
		UserAccountEntity userAccountEntitySaved = userAccountPersistence.save(userAccountEntity);
		return userAccountServiceMapper.mapUserAccountEntityToUserAccount(userAccountEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		userAccountPersistence.delete(id);
	}

	public UserAccountPersistence getUserAccountPersistence() {
		return userAccountPersistence;
	}

	public void setUserAccountPersistence(UserAccountPersistence userAccountPersistence) {
		this.userAccountPersistence = userAccountPersistence;
	}

	public UserAccountServiceMapper getUserAccountServiceMapper() {
		return userAccountServiceMapper;
	}

	public void setUserAccountServiceMapper(UserAccountServiceMapper userAccountServiceMapper) {
		this.userAccountServiceMapper = userAccountServiceMapper;
	}

}