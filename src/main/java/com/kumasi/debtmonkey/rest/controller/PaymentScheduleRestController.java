/*
 * Created on 23 Nov 2016 ( Time 15:22:18 )
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
import com.kumasi.debtmonkey.model.PaymentSchedule;
import com.kumasi.debtmonkey.business.service.PaymentScheduleService;
import com.kumasi.debtmonkey.web.listitem.PaymentScheduleListItem;

/**
 * Spring MVC controller for 'PaymentSchedule' management.
 */
@Controller
public class PaymentScheduleRestController {

	@Resource
	private PaymentScheduleService paymentScheduleService;
	
	@RequestMapping( value="/items/paymentSchedule",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PaymentScheduleListItem> findAllAsListItems() {
		List<PaymentSchedule> list = paymentScheduleService.findAll();
		List<PaymentScheduleListItem> items = new LinkedList<PaymentScheduleListItem>();
		for ( PaymentSchedule paymentSchedule : list ) {
			items.add(new PaymentScheduleListItem( paymentSchedule ) );
		}
		return items;
	}
	
	@RequestMapping( value="/paymentSchedule",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PaymentSchedule> findAll() {
		return paymentScheduleService.findAll();
	}

	@RequestMapping( value="/paymentSchedule/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PaymentSchedule findOne(@PathVariable("id") Integer id) {
		return paymentScheduleService.findById(id);
	}
	
	@RequestMapping( value="/paymentSchedule",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PaymentSchedule create(@RequestBody PaymentSchedule paymentSchedule) {
		return paymentScheduleService.create(paymentSchedule);
	}

	@RequestMapping( value="/paymentSchedule/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PaymentSchedule update(@PathVariable("id") Integer id, @RequestBody PaymentSchedule paymentSchedule) {
		return paymentScheduleService.update(paymentSchedule);
	}

	@RequestMapping( value="/paymentSchedule/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		paymentScheduleService.delete(id);
	}
	
}
