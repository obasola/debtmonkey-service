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
import com.kumasi.debtmonkey.model.AccountType;
import com.kumasi.debtmonkey.business.service.AccountTypeService;
import com.kumasi.debtmonkey.web.listitem.AccountTypeListItem;

/**
 * Spring MVC controller for 'AccountType' management.
 */
@Controller
public class AccountTypeRestController {

	@Resource
	private AccountTypeService accountTypeService;
	
	@RequestMapping( value="/items/accountType",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccountTypeListItem> findAllAsListItems() {
		List<AccountType> list = accountTypeService.findAll();
		List<AccountTypeListItem> items = new LinkedList<AccountTypeListItem>();
		for ( AccountType accountType : list ) {
			items.add(new AccountTypeListItem( accountType ) );
		}
		return items;
	}
	
	@RequestMapping( value="/accountType",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccountType> findAll() {
		return accountTypeService.findAll();
	}

	@RequestMapping( value="/accountType/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccountType findOne(@PathVariable("id") Integer id) {
		return accountTypeService.findById(id);
	}
	
	@RequestMapping( value="/accountType",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccountType create(@RequestBody AccountType accountType) {
		return accountTypeService.create(accountType);
	}

	@RequestMapping( value="/accountType/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AccountType update(@PathVariable("id") Integer id, @RequestBody AccountType accountType) {
		return accountTypeService.update(accountType);
	}

	@RequestMapping( value="/accountType/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		accountTypeService.delete(id);
	}
	
}
