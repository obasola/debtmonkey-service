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

import net.kumasi.debtmonkey.domain.UserRole;
import net.kumasi.debtmonkey.domain.jpa.UserRoleEntity;
import net.kumasi.debtmonkey.domain.jpa.UserRoleEntityKey;
import net.kumasi.debtmonkey.business.service.UserRoleService;
import net.kumasi.debtmonkey.business.service.mapping.UserRoleServiceMapper;
import net.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import net.kumasi.debtmonkey.persistence.services.UserRolePersistence;
import org.springframework.stereotype.Component;

/**
 * Implementation of UserRoleService
 */
@Component
public class UserRoleServiceImpl implements UserRoleService {

	private UserRolePersistence userRolePersistence;

	@Resource
	private UserRoleServiceMapper userRoleServiceMapper;
	
	public UserRoleServiceImpl() {
		userRolePersistence = PersistenceServiceProvider.getService(UserRolePersistence.class);
	}
		
	@Override
	public UserRole findById(Integer userAccountId, Integer roleRoleId) {
		UserRoleEntity entity = userRolePersistence.load(userAccountId, roleRoleId);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(entity);
	}

	@Override
	public List<UserRole> findAll() {
		List<UserRoleEntity> entities = userRolePersistence.loadAll();
		List<UserRole> beans = new ArrayList<UserRole>();
		for(UserRoleEntity entity : entities) {
			beans.add(userRoleServiceMapper.mapUserRoleEntityToUserRole(entity));
		}
		return beans;
	}

	@Override
	public UserRole save(UserRole userRole) {
		return update(userRole) ;
	}

	@Override
	public UserRole create(UserRole userRole) {
		if(userRolePersistence.load(userRole.getUserAccount().getId(), userRole.getRole().getRoleId()) != null) {
			throw new IllegalStateException("already.exists");
		}
		UserRoleEntity userRoleEntity = new UserRoleEntity();
		userRoleServiceMapper.mapUserRoleToUserRoleEntity(userRole, userRoleEntity);
		UserRoleEntity userRoleEntitySaved = userRolePersistence.save(userRoleEntity);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntitySaved);
	}

	@Override
	public UserRole update(UserRole userRole) {
		UserRoleEntity userRoleEntity = userRolePersistence.load(userRole.getUserAccount().getId(), userRole.getRole().getRoleId());
		userRoleServiceMapper.mapUserRoleToUserRoleEntity(userRole, userRoleEntity);
		UserRoleEntity userRoleEntitySaved = userRolePersistence.save(userRoleEntity);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntitySaved);
	}

	@Override
	public void delete(Integer userAccountId, Integer roleRoleId) {
		userRolePersistence.delete(userAccountId, roleRoleId);
	}

	public UserRolePersistence getUserRolePersistence() {
		return userRolePersistence;
	}

	public void setUserRolePersistence(UserRolePersistence userRolePersistence) {
		this.userRolePersistence = userRolePersistence;
	}

	public UserRoleServiceMapper getUserRoleServiceMapper() {
		return userRoleServiceMapper;
	}

	public void setUserRoleServiceMapper(UserRoleServiceMapper userRoleServiceMapper) {
		this.userRoleServiceMapper = userRoleServiceMapper;
	}

}
