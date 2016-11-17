/*
 * Created on 6 Sep 2016 ( Time 17:16:57 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.kumasi.debtmonkey.model.AccountAddress;
import com.kumasi.debtmonkey.business.service.AccountAddressService;
import com.kumasi.debtmonkey.web.listitem.AccountAddressListItem;

/**
 * Spring MVC controller for 'AccountAddress' management.
 */
@Controller
public class AccountAddressRestController {

	@Resource
	private AccountAddressService accountAddressService;
	
	@RequestMapping( value="/items/accountAddress",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccountAddressListItem> findAllAsListItems() {
		List<AccountAddress> list = accountAddressService.findAll();
		List<AccountAddressListItem> items = new LinkedList<AccountAddressListItem>();
		for ( AccountAddress accountAddress : list ) {
			items.add(new AccountAddressListItem( accountAddress ) );
		}
		return items;
	}
	
	@RequestMapping( value="/accountAddress",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccountAddress> findAll() {
		return accountAddressService.findAll();
	}

	@RequestMapping( value="/accountAddress/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccountAddress findOne(@PathVariable("id") Integer id) {
		return accountAddressService.findById(id);
	}
	
	@RequestMapping( value="/accountAddress",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccountAddress create(@RequestBody AccountAddress accountAddress) {
		return accountAddressService.create(accountAddress);
	}

	@RequestMapping( value="/accountAddress/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccountAddress update(@PathVariable("id") Integer id, @RequestBody AccountAddress accountAddress) {
		return accountAddressService.update(accountAddress);
	}

	@RequestMapping( value="/accountAddress/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		accountAddressService.delete(id);
	}
	
}