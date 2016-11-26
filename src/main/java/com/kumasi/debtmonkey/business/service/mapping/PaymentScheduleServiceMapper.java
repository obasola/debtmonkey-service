/*
 * Created on 24 Nov 2016 ( Time 14:57:03 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.kumasi.debtmonkey.model.PaymentSchedule;
import com.kumasi.debtmonkey.model.jpa.PaymentScheduleEntity;
import com.kumasi.debtmonkey.model.jpa.AccountEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PaymentScheduleServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public PaymentScheduleServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'PaymentScheduleEntity' to 'PaymentSchedule'
	 * @param paymentScheduleEntity
	 */
	public PaymentSchedule mapPaymentScheduleEntityToPaymentSchedule(PaymentScheduleEntity paymentScheduleEntity) {
		if(paymentScheduleEntity == null) {
			return null;
		}

		//--- Generic mapping 
		PaymentSchedule paymentSchedule = map(paymentScheduleEntity, PaymentSchedule.class);

		//--- Link mapping ( link to Account )
		if(paymentScheduleEntity.getAccount() != null) {
			paymentSchedule.setAccountId(paymentScheduleEntity.getAccount().getId());
		}
		return paymentSchedule;
	}
	
	/**
	 * Mapping from 'PaymentSchedule' to 'PaymentScheduleEntity'
	 * @param paymentSchedule
	 * @param paymentScheduleEntity
	 */
	public void mapPaymentScheduleToPaymentScheduleEntity(PaymentSchedule paymentSchedule, PaymentScheduleEntity paymentScheduleEntity) {
		if(paymentSchedule == null) {
			return;
		}

		//--- Generic mapping 
		map(paymentSchedule, paymentScheduleEntity);

		//--- Link mapping ( link : paymentSchedule )
		if( hasLinkToAccount(paymentSchedule) ) {
			AccountEntity account1 = new AccountEntity();
			account1.setId( paymentSchedule.getAccountId() );
			paymentScheduleEntity.setAccount( account1 );
		} else {
			paymentScheduleEntity.setAccount( null );
		}

	}
	
	/**
	 * Verify that Account id is valid.
	 * @param Account Account
	 * @return boolean
	 */
	private boolean hasLinkToAccount(PaymentSchedule paymentSchedule) {
		if(paymentSchedule.getAccountId() != null) {
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