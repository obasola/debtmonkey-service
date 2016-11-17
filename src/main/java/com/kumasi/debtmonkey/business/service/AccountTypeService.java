/*
 * Created on 6 Sep 2016 ( Time 17:16:57 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service;

import java.util.List;

import com.kumasi.debtmonkey.model.AccountType;

/**
 * Business Service Interface for entity AccountType.
 */
public interface AccountTypeService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	AccountType findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<AccountType> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	AccountType save(AccountType entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	AccountType update(AccountType entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	AccountType create(AccountType entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
