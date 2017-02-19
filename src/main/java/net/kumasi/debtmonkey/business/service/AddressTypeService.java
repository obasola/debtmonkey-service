/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service;

import java.util.List;

import net.kumasi.debtmonkey.domain.AddressType;

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