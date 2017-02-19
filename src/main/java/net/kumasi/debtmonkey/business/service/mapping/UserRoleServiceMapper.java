/*
 * Created on 17 Feb 2017 ( Time 16:36:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.kumasi.debtmonkey.domain.UserRole;
import net.kumasi.debtmonkey.domain.jpa.UserRoleEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UserRoleServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public UserRoleServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'UserRoleEntity' to 'UserRole'
	 * @param userRoleEntity
	 */
	public UserRole mapUserRoleEntityToUserRole(UserRoleEntity userRoleEntity) {
		if(userRoleEntity == null) {
			return null;
		}

		//--- Generic mapping 
		UserRole userRole = map(userRoleEntity, UserRole.class);

		return userRole;
	}
	
	/**
	 * Mapping from 'UserRole' to 'UserRoleEntity'
	 * @param userRole
	 * @param userRoleEntity
	 */
	public void mapUserRoleToUserRoleEntity(UserRole userRole, UserRoleEntity userRoleEntity) {
		if(userRole == null) {
			return;
		}

		//--- Generic mapping 
		map(userRole, userRoleEntity);

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