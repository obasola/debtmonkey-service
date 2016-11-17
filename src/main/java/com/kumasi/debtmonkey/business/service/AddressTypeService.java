/*
 * Created on 6 Sep 2016 ( Time 17:16:57 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.business.service;

import java.util.List;

import com.kumasi.debtmonkey.model.AddressType;

/**
 * Business Service Interface for entity AddressType.
 */
public interface AddressTypeService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	AddressType findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<AddressType> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	AddressType save(AddressType entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	AddressType update(AddressType entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	AddressType create(AddressType entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
