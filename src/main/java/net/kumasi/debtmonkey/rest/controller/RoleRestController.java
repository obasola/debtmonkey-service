/*
 * Created on 17 Feb 2017 ( Time 16:36:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.kumasi.debtmonkey.rest.controller;

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
import net.kumasi.debtmonkey.domain.Role;
import net.kumasi.debtmonkey.business.service.RoleService;
import net.kumasi.debtmonkey.web.listitem.RoleListItem;

/**
 * Spring MVC controller for 'Role' management.
 */
@Controller
public class RoleRestController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping( value="/items/role",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<RoleListItem> findAllAsListItems() {
		List<Role> list = roleService.findAll();
		List<RoleListItem> items = new LinkedList<RoleListItem>();
		for ( Role role : list ) {
			items.add(new RoleListItem( role ) );
		}
		return items;
	}
	
	@RequestMapping( value="/role",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@RequestMapping( value="/role/{roleId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Role findOne(@PathVariable("roleId") Integer roleId) {
		return roleService.findById(roleId);
	}
	
	@RequestMapping( value="/role",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Role create(@RequestBody Role role) {
		return roleService.create(role);
	}

	@RequestMapping( value="/role/{roleId}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Role update(@PathVariable("roleId") Integer roleId, @RequestBody Role role) {
		return roleService.update(role);
	}

	@RequestMapping( value="/role/{roleId}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("roleId") Integer roleId) {
		roleService.delete(roleId);
	}
	
}