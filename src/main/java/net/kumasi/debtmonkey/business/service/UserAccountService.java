/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.business.service;

import java.util.List;

import net.kumasi.debtmonkey.domain.UserAccount;

/**
 * Business Service Interface for entity UserAccount.
 */
public interface UserAccountService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	UserAccount findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<UserAccount> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	UserAccount save(UserAccount entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	UserAccount update(UserAccount entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	UserAccount create(UserAccount entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}