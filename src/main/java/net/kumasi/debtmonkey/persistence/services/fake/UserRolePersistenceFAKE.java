/*
 * Created on 17 Feb 2017 ( Time 16:36:17 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.persistence.services.fake;

import java.util.List;
import java.util.Map;

import net.kumasi.debtmonkey.domain.jpa.UserRoleEntity;
import net.kumasi.debtmonkey.persistence.commons.fake.GenericFakeService;
import net.kumasi.debtmonkey.persistence.services.UserRolePersistence;

/**
 * Fake persistence service implementation ( entity "UserRole" )
 *
 * @author Telosys Tools Generator
 */
public class UserRolePersistenceFAKE extends GenericFakeService<UserRoleEntity> implements UserRolePersistence {

	public UserRolePersistenceFAKE () {
		super(UserRoleEntity.class);
	}
	
	protected UserRoleEntity buildEntity(int index) {
		UserRoleEntity entity = new UserRoleEntity();
		// Init fields with mock values
		entity.setUserAccountId( nextInteger() ) ;
		entity.setRoleRoleId( nextInteger() ) ;
		return entity ;
	}
	
	
	public boolean delete(UserRoleEntity entity) {
		log("delete ( UserRoleEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer userAccountId, Integer roleRoleId ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(UserRoleEntity entity) {
		log("insert ( UserRoleEntity : " + entity + ")" ) ;
	}

	public UserRoleEntity load( Integer userAccountId, Integer roleRoleId ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<UserRoleEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<UserRoleEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<UserRoleEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public UserRoleEntity save(UserRoleEntity entity) {
		log("insert ( UserRoleEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<UserRoleEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
