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

import net.kumasi.debtmonkey.domain.PaymentHistory;
import net.kumasi.debtmonkey.domain.jpa.PaymentHistoryEntity;
import java.util.Date;
import net.kumasi.debtmonkey.business.service.mapping.PaymentHistoryServiceMapper;
import net.kumasi.debtmonkey.persistence.services.jpa.PaymentHistoryPersistenceJPA;
import net.kumasi.debtmonkey.test.PaymentHistoryFactoryForTest;
import net.kumasi.debtmonkey.test.PaymentHistoryEntityFactoryForTest;
import net.kumasi.debtmonkey.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of PaymentHistoryService
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentHistoryServiceImplTest {

	@InjectMocks
	private PaymentHistoryServiceImpl paymentHistoryService;
	@Mock
	private PaymentHistoryPersistenceJPA paymentHistoryPersistenceJPA;
	@Mock
	private PaymentHistoryServiceMapper paymentHistoryServiceMapper;
	
	private PaymentHistoryFactoryForTest paymentHistoryFactoryForTest = new PaymentHistoryFactoryForTest();

	private PaymentHistoryEntityFactoryForTest paymentHistoryEntityFactoryForTest = new PaymentHistoryEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer idpaymentHistory = mockValues.nextInteger();
		
		PaymentHistoryEntity paymentHistoryEntity = paymentHistoryPersistenceJPA.load(idpaymentHistory);
		
		PaymentHistory paymentHistory = paymentHistoryFactoryForTest.newPaymentHistory();
		when(paymentHistoryServiceMapper.mapPaymentHistoryEntityToPaymentHistory(paymentHistoryEntity)).thenReturn(paymentHistory);

		// When
		PaymentHistory paymentHistoryFound = paymentHistoryService.findById(idpaymentHistory);

		// Then
		assertEquals(paymentHistory.getIdpaymentHistory(),paymentHistoryFound.getIdpaymentHistory());
	}

	@Test
	public void findAll() {
		// Given
		List<PaymentHistoryEntity> paymentHistoryEntitys = new ArrayList<PaymentHistoryEntity>();
		PaymentHistoryEntity paymentHistoryEntity1 = paymentHistoryEntityFactoryForTest.newPaymentHistoryEntity();
		paymentHistoryEntitys.add(paymentHistoryEntity1);
		PaymentHistoryEntity paymentHistoryEntity2 = paymentHistoryEntityFactoryForTest.newPaymentHistoryEntity();
		paymentHistoryEntitys.add(paymentHistoryEntity2);
		when(paymentHistoryPersistenceJPA.loadAll()).thenReturn(paymentHistoryEntitys);
		
		PaymentHistory paymentHistory1 = paymentHistoryFactoryForTest.newPaymentHistory();
		when(paymentHistoryServiceMapper.mapPaymentHistoryEntityToPaymentHistory(paymentHistoryEntity1)).thenReturn(paymentHistory1);
		PaymentHistory paymentHistory2 = paymentHistoryFactoryForTest.newPaymentHistory();
		when(paymentHistoryServiceMapper.mapPaymentHistoryEntityToPaymentHistory(paymentHistoryEntity2)).thenReturn(paymentHistory2);

		// When
		List<PaymentHistory> paymentHistorysFounds = paymentHistoryService.findAll();

		// Then
		assertTrue(paymentHistory1 == paymentHistorysFounds.get(0));
		assertTrue(paymentHistory2 == paymentHistorysFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		PaymentHistory paymentHistory = paymentHistoryFactoryForTest.newPaymentHistory();

		PaymentHistoryEntity paymentHistoryEntity = paymentHistoryEntityFactoryForTest.newPaymentHistoryEntity();
		when(paymentHistoryPersistenceJPA.load(paymentHistory.getIdpaymentHistory())).thenReturn(null);
		
		paymentHistoryEntity = new PaymentHistoryEntity();
		paymentHistoryServiceMapper.mapPaymentHistoryToPaymentHistoryEntity(paymentHistory, paymentHistoryEntity);
		PaymentHistoryEntity paymentHistoryEntitySaved = paymentHistoryPersistenceJPA.save(paymentHistoryEntity);
		
		PaymentHistory paymentHistorySaved = paymentHistoryFactoryForTest.newPaymentHistory();
		when(paymentHistoryServiceMapper.mapPaymentHistoryEntityToPaymentHistory(paymentHistoryEntitySaved)).thenReturn(paymentHistorySaved);

		// When
		PaymentHistory paymentHistoryResult = paymentHistoryService.create(paymentHistory);

		// Then
		assertTrue(paymentHistoryResult == paymentHistorySaved);
	}

	@Test
	public void createKOExists() {
		// Given
		PaymentHistory paymentHistory = paymentHistoryFactoryForTest.newPaymentHistory();

		PaymentHistoryEntity paymentHistoryEntity = paymentHistoryEntityFactoryForTest.newPaymentHistoryEntity();
		when(paymentHistoryPersistenceJPA.load(paymentHistory.getIdpaymentHistory())).thenReturn(paymentHistoryEntity);

		// When
		Exception exception = null;
		try {
			paymentHistoryService.create(paymentHistory);
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
		PaymentHistory paymentHistory = paymentHistoryFactoryForTest.newPaymentHistory();

		PaymentHistoryEntity paymentHistoryEntity = paymentHistoryEntityFactoryForTest.newPaymentHistoryEntity();
		when(paymentHistoryPersistenceJPA.load(paymentHistory.getIdpaymentHistory())).thenReturn(paymentHistoryEntity);
		
		PaymentHistoryEntity paymentHistoryEntitySaved = paymentHistoryEntityFactoryForTest.newPaymentHistoryEntity();
		when(paymentHistoryPersistenceJPA.save(paymentHistoryEntity)).thenReturn(paymentHistoryEntitySaved);
		
		PaymentHistory paymentHistorySaved = paymentHistoryFactoryForTest.newPaymentHistory();
		when(paymentHistoryServiceMapper.mapPaymentHistoryEntityToPaymentHistory(paymentHistoryEntitySaved)).thenReturn(paymentHistorySaved);

		// When
		PaymentHistory paymentHistoryResult = paymentHistoryService.update(paymentHistory);

		// Then
		verify(paymentHistoryServiceMapper).mapPaymentHistoryToPaymentHistoryEntity(paymentHistory, paymentHistoryEntity);
		assertTrue(paymentHistoryResult == paymentHistorySaved);
	}

	@Test
	public void delete() {
		// Given
		Integer idpaymentHistory = mockValues.nextInteger();

		// When
		paymentHistoryService.delete(idpaymentHistory);

		// Then
		verify(paymentHistoryPersistenceJPA).delete(idpaymentHistory);
		
	}

}