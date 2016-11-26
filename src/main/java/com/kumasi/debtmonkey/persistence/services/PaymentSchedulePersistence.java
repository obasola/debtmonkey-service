/*
 * Created on 24 Nov 2016 ( Time 14:55:42 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.persistence.services;

import java.util.List;
import java.util.Map;

import com.kumasi.debtmonkey.model.jpa.PaymentScheduleEntity;

/**
 * Basic persistence operations for entity "PaymentSchedule"
 * 
 * This Bean has a basic Primary Key : Integer
 *
 * @author Telosys Tools Generator
 *
 */
public interface PaymentSchedulePersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param paymentSchedule
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(PaymentScheduleEntity paymentSchedule) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param id
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer id) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param paymentSchedule
	 */
	public void insert(PaymentScheduleEntity paymentSchedule) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param id
	 * @return the entity loaded (or null if not found)
	 */
	public PaymentScheduleEntity load(Integer id) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<PaymentScheduleEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<PaymentScheduleEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<PaymentScheduleEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param paymentSchedule
	 * @return
	 */
	public PaymentScheduleEntity save(PaymentScheduleEntity paymentSchedule) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<PaymentScheduleEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
