/*
 * Created on 6 Sep 2016 ( Time 17:16:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.kumasi.debtmonkey.model.AccountAddress;
import com.kumasi.debtmonkey.model.jpa.AccountAddressEntity;
import com.kumasi.debtmonkey.model.jpa.AccountEntity;
import com.kumasi.debtmonkey.model.jpa.AccountTypeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AccountAddressServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AccountAddressServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AccountAddressEntity' to 'AccountAddress'
	 * @param accountAddressEntity
	 */
	public AccountAddress mapAccountAddressEntityToAccountAddress(AccountAddressEntity accountAddressEntity) {
		if(accountAddressEntity == null) {
			return null;
		}

		//--- Generic mapping 
		AccountAddress accountAddress = map(accountAddressEntity, AccountAddress.class);

		//--- Link mapping ( link to Account )
		if(accountAddressEntity.getAccount() != null) {
			accountAddress.setAccountId(accountAddressEntity.getAccount().getId());
		}
		//--- Link mapping ( link to AccountType )
		if(accountAddressEntity.getAccountType() != null) {
			accountAddress.setAccountTypeId(accountAddressEntity.getAccountType().getId());
		}
		return accountAddress;
	}
	
	/**
	 * Mapping from 'AccountAddress' to 'AccountAddressEntity'
	 * @param accountAddress
	 * @param accountAddressEntity
	 */
	public void mapAccountAddressToAccountAddressEntity(AccountAddress accountAddress, AccountAddressEntity accountAddressEntity) {
		if(accountAddress == null) {
			return;
		}

		//--- Generic mapping 
		map(accountAddress, accountAddressEntity);

		//--- Link mapping ( link : accountAddress )
		if( hasLinkToAccount(accountAddress) ) {
			AccountEntity account1 = new AccountEntity();
			account1.setId( accountAddress.getAccountId() );
			accountAddressEntity.setAccount( account1 );
		} else {
			accountAddressEntity.setAccount( null );
		}

		//--- Link mapping ( link : accountAddress )
		if( hasLinkToAccountType(accountAddress) ) {
			AccountTypeEntity accountType2 = new AccountTypeEntity();
			accountType2.setId( accountAddress.getAccountTypeId() );
			accountAddressEntity.setAccountType( accountType2 );
		} else {
			accountAddressEntity.setAccountType( null );
		}

	}
	
	/**
	 * Verify that Account id is valid.
	 * @param Account Account
	 * @return boolean
	 */
	private boolean hasLinkToAccount(AccountAddress accountAddress) {
		if(accountAddress.getAccountId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that AccountType id is valid.
	 * @param AccountType AccountType
	 * @return boolean
	 */
	private boolean hasLinkToAccountType(AccountAddress accountAddress) {
		if(accountAddress.getAccountTypeId() != null) {
			return true;
		}
		return false;
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