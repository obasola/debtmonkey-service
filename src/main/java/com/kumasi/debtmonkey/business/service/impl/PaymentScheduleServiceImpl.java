/*
 * Created on 24 Nov 2016 ( Time 14:57:03 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kumasi.debtmonkey.business.service.PaymentScheduleService;
import com.kumasi.debtmonkey.business.service.mapping.PaymentScheduleServiceMapper;
import com.kumasi.debtmonkey.model.PaymentSchedule;
import com.kumasi.debtmonkey.model.jpa.PaymentScheduleEntity;
import com.kumasi.debtmonkey.persistence.PersistenceServiceProvider;
import com.kumasi.debtmonkey.persistence.services.PaymentSchedulePersistence;

/**
 * Implementation of PaymentScheduleService
 */
@Component
public class PaymentScheduleServiceImpl implements PaymentScheduleService {	
	
	private PaymentSchedulePersistence paymentSchedulePersistence;

	@Resource
	private PaymentScheduleServiceMapper paymentScheduleServiceMapper;
	
	public PaymentScheduleServiceImpl() {
		paymentSchedulePersistence = PersistenceServiceProvider.getService(PaymentSchedulePersistence.class);
	}
		
	@Override
	public PaymentSchedule findById(Integer id) {
		PaymentScheduleEntity entity = paymentSchedulePersistence.load(id);
		return paymentScheduleServiceMapper.mapPaymentScheduleEntityToPaymentSchedule(entity);
	}

	@Override
	public List<PaymentSchedule> findAll() {
		List<PaymentScheduleEntity> entities = paymentSchedulePersistence.loadAll();
		List<PaymentSchedule> beans = new ArrayList<PaymentSchedule>();
		for(PaymentScheduleEntity entity : entities) {
			beans.add(paymentScheduleServiceMapper.mapPaymentScheduleEntityToPaymentSchedule(entity));
		}
		return beans;
	}

	@Override
	public PaymentSchedule save(PaymentSchedule paymentSchedule) {
		return update(paymentSchedule) ;
	}

	@Override
	public PaymentSchedule create(PaymentSchedule paymentSchedule) {
		if(paymentSchedulePersistence.load(paymentSchedule.getId()) != null) {
			throw new IllegalStateException("already.exists");
		}
		PaymentScheduleEntity paymentScheduleEntity = new PaymentScheduleEntity();
		paymentScheduleServiceMapper.mapPaymentScheduleToPaymentScheduleEntity(paymentSchedule, paymentScheduleEntity);
		PaymentScheduleEntity paymentScheduleEntitySaved = paymentSchedulePersistence.save(paymentScheduleEntity);
		return paymentScheduleServiceMapper.mapPaymentScheduleEntityToPaymentSchedule(paymentScheduleEntitySaved);
	}

	@Override
	public PaymentSchedule update(PaymentSchedule paymentSchedule) {
		PaymentScheduleEntity paymentScheduleEntity = paymentSchedulePersistence.load(paymentSchedule.getId());
		paymentScheduleServiceMapper.mapPaymentScheduleToPaymentScheduleEntity(paymentSchedule, paymentScheduleEntity);
		PaymentScheduleEntity paymentScheduleEntitySaved = paymentSchedulePersistence.save(paymentScheduleEntity);
		return paymentScheduleServiceMapper.mapPaymentScheduleEntityToPaymentSchedule(paymentScheduleEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		paymentSchedulePersistence.delete(id);
	}

	public PaymentSchedulePersistence getPaymentSchedulePersistence() {
		return paymentSchedulePersistence;
	}

	public void setPaymentSchedulePersistence(PaymentSchedulePersistence paymentSchedulePersistence) {
		this.paymentSchedulePersistence = paymentSchedulePersistence;
	}

	public PaymentScheduleServiceMapper getPaymentScheduleServiceMapper() {
		return paymentScheduleServiceMapper;
	}

	public void setPaymentScheduleServiceMapper(PaymentScheduleServiceMapper paymentScheduleServiceMapper) {
		this.paymentScheduleServiceMapper = paymentScheduleServiceMapper;
	}

}
