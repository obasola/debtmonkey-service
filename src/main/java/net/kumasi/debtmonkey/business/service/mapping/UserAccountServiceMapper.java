/*
 * Created on 17 Feb 2017 ( Time 16:36:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.kumasi.debtmonkey.domain.UserAccount;
import net.kumasi.debtmonkey.domain.jpa.UserAccountEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UserAccountServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public UserAccountServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'UserAccountEntity' to 'UserAccount'
	 * @param userAccountEntity
	 */
	public UserAccount mapUserAccountEntityToUserAccount(UserAccountEntity userAccountEntity) {
		if(userAccountEntity == null) {
			return null;
		}

		//--- Generic mapping 
		UserAccount userAccount = map(userAccountEntity, UserAccount.class);

		return userAccount;
	}
	
	/**
	 * Mapping from 'UserAccount' to 'UserAccountEntity'
	 * @param userAccount
	 * @param userAccountEntity
	 */
	public void mapUserAccountToUserAccountEntity(UserAccount userAccount, UserAccountEntity userAccountEntity) {
		if(userAccount == null) {
			return;
		}

		//--- Generic mapping 
		map(userAccount, userAccountEntity);

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