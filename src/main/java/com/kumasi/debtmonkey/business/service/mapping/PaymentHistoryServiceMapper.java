/*
 * Created on 23 Nov 2016 ( Time 14:35:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.kumasi.debtmonkey.model.PaymentHistory;
import com.kumasi.debtmonkey.model.jpa.PaymentHistoryEntity;
import com.kumasi.debtmonkey.model.jpa.AccountEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PaymentHistoryServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public PaymentHistoryServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'PaymentHistoryEntity' to 'PaymentHistory'
	 * @param paymentHistoryEntity
	 */
	public PaymentHistory mapPaymentHistoryEntityToPaymentHistory(PaymentHistoryEntity paymentHistoryEntity) {
		if(paymentHistoryEntity == null) {
			return null;
		}

		//--- Generic mapping 
		PaymentHistory paymentHistory = map(paymentHistoryEntity, PaymentHistory.class);

		//--- Link mapping ( link to Account )
		if(paymentHistoryEntity.getAccount() != null) {
			paymentHistory.setAccountId(paymentHistoryEntity.getAccount().getId());
		}
		return paymentHistory;
	}
	
	/**
	 * Mapping from 'PaymentHistory' to 'PaymentHistoryEntity'
	 * @param paymentHistory
	 * @param paymentHistoryEntity
	 */
	public void mapPaymentHistoryToPaymentHistoryEntity(PaymentHistory paymentHistory, PaymentHistoryEntity paymentHistoryEntity) {
		if(paymentHistory == null) {
			return;
		}

		//--- Generic mapping 
		map(paymentHistory, paymentHistoryEntity);

		//--- Link mapping ( link : paymentHistory )
		if( hasLinkToAccount(paymentHistory) ) {
			AccountEntity account1 = new AccountEntity();
			account1.setId( paymentHistory.getAccountId() );
			paymentHistoryEntity.setAccount( account1 );
		} else {
			paymentHistoryEntity.setAccount( null );
		}

	}
	
	/**
	 * Verify that Account id is valid.
	 * @param Account Account
	 * @return boolean
	 */
	private boolean hasLinkToAccount(PaymentHistory paymentHistory) {
		if(paymentHistory.getAccountId() != null) {
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