/*
 * Created on 17 Feb 2017 ( Time 16:36:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.kumasi.debtmonkey.domain.UserRole;
import net.kumasi.debtmonkey.domain.jpa.UserRoleEntity;
import net.kumasi.debtmonkey.domain.jpa.UserRoleEntityKey;
import net.kumasi.debtmonkey.business.service.mapping.UserRoleServiceMapper;
import net.kumasi.debtmonkey.persistence.services.jpa.UserRolePersistenceJPA;
import net.kumasi.debtmonkey.test.UserRoleFactoryForTest;
import net.kumasi.debtmonkey.test.UserRoleEntityFactoryForTest;
import net.kumasi.debtmonkey.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of UserRoleService
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRoleServiceImplTest {

	@InjectMocks
	private UserRoleServiceImpl userRoleService;
	@Mock
	private UserRolePersistenceJPA userRolePersistenceJPA;
	@Mock
	private UserRoleServiceMapper userRoleServiceMapper;
	
	private UserRoleFactoryForTest userRoleFactoryForTest = new UserRoleFactoryForTest();

	private UserRoleEntityFactoryForTest userRoleEntityFactoryForTest = new UserRoleEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer userAccountId = mockValues.nextInteger();
		Integer roleRoleId = mockValues.nextInteger();
		
		UserRoleEntityKey userRoleEntityKey = new UserRoleEntityKey(userAccountId, roleRoleId);
		userRoleEntityKey.setUserAccountId(userAccountId);
		userRoleEntityKey.setRoleRoleId(roleRoleId);
		
		UserRoleEntity userRoleEntity = userRolePersistenceJPA.load(userRoleEntityKey);
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		when(userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntity)).thenReturn(userRole);

		// When
		UserRole userRoleFound = userRoleService.findById(userAccountId, roleRoleId);

		// Then
		assertEquals(userRole.getUserAccountId(),userRoleFound.getUserAccountId());
		assertEquals(userRole.getRoleRoleId(),userRoleFound.getRoleRoleId());
	}

	@Test
	public void findAll() {
		// Given
		List<UserRoleEntity> userRoleEntitys = new ArrayList<UserRoleEntity>();
		UserRoleEntity userRoleEntity1 = userRoleEntityFactoryForTest.newUserRoleEntity();
		userRoleEntitys.add(userRoleEntity1);
		UserRoleEntity userRoleEntity2 = userRoleEntityFactoryForTest.newUserRoleEntity();
		userRoleEntitys.add(userRoleEntity2);
		when(userRolePersistenceJPA.loadAll()).thenReturn(userRoleEntitys);
		
		UserRole userRole1 = userRoleFactoryForTest.newUserRole();
		when(userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntity1)).thenReturn(userRole1);
		UserRole userRole2 = userRoleFactoryForTest.newUserRole();
		when(userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntity2)).thenReturn(userRole2);

		// When
		List<UserRole> userRolesFounds = userRoleService.findAll();

		// Then
		assertTrue(userRole1 == userRolesFounds.get(0));
		assertTrue(userRole2 == userRolesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		UserRole userRole = userRoleFactoryForTest.newUserRole();

		UserRoleEntity userRoleEntity = userRoleEntityFactoryForTest.newUserRoleEntity();
		when(userRolePersistenceJPA.load(userRole.getUserAccountId(), userRole.getRoleRoleId())).thenReturn(null);
		
		userRoleEntity = new UserRoleEntity();
		userRoleServiceMapper.mapUserRoleToUserRoleEntity(userRole, userRoleEntity);
		UserRoleEntity userRoleEntitySaved = userRolePersistenceJPA.save(userRoleEntity);
		
		UserRole userRoleSaved = userRoleFactoryForTest.newUserRole();
		when(userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntitySaved)).thenReturn(userRoleSaved);

		// When
		UserRole userRoleResult = userRoleService.create(userRole);

		// Then
		assertTrue(userRoleResult == userRoleSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		UserRole userRole = userRoleFactoryForTest.newUserRole();

		UserRoleEntity userRoleEntity = userRoleEntityFactoryForTest.newUserRoleEntity();
		when(userRolePersistenceJPA.load(userRole.getUserAccountId(), userRole.getRoleRoleId())).thenReturn(userRoleEntity);

		// When
		Exception exception = null;
		try {
			userRoleService.create(userRole);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		UserRole userRole = userRoleFactoryForTest.newUserRole();

		UserRoleEntity userRoleEntity = userRoleEntityFactoryForTest.newUserRoleEntity();
		when(userRolePersistenceJPA.load(userRole.getUserAccountId(), userRole.getRoleRoleId())).thenReturn(userRoleEntity);
		
		UserRoleEntity userRoleEntitySaved = userRoleEntityFactoryForTest.newUserRoleEntity();
		when(userRolePersistenceJPA.save(userRoleEntity)).thenReturn(userRoleEntitySaved);
		
		UserRole userRoleSaved = userRoleFactoryForTest.newUserRole();
		when(userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntitySaved)).thenReturn(userRoleSaved);

		// When
		UserRole userRoleResult = userRoleService.update(userRole);

		// Then
		verify(userRoleServiceMapper).mapUserRoleToUserRoleEntity(userRole, userRoleEntity);
		assertTrue(userRoleResult == userRoleSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer userAccountId = mockValues.nextInteger();
		Integer roleRoleId = mockValues.nextInteger();

		// When
		userRoleService.delete(userAccountId, roleRoleId);

		// Then
		verify(userRolePersistenceJPA).delete(userAccountId, roleRoleId);
		
	}

}