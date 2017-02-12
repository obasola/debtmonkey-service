/*
 * Created on 11 Feb 2017 ( Time 18:00:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.kumasi.debtmonkey.web.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Common classes
import com.kumasi.debtmonkey.web.common.AbstractController;
import com.kumasi.debtmonkey.web.common.FormMode;
import com.kumasi.debtmonkey.web.common.Message;
import com.kumasi.debtmonkey.web.common.MessageType;

//--- Entities
import com.kumasi.debtmonkey.model.AccountAddress;
import com.kumasi.debtmonkey.model.AddressType;
import com.kumasi.debtmonkey.model.Account;
import com.kumasi.debtmonkey.model.AccountType;

//--- Services 
import com.kumasi.debtmonkey.business.service.AccountAddressService;
import com.kumasi.debtmonkey.business.service.AddressTypeService;
import com.kumasi.debtmonkey.business.service.AccountService;
import com.kumasi.debtmonkey.business.service.AccountTypeService;

//--- List Items 
import com.kumasi.debtmonkey.web.listitem.AddressTypeListItem;
import com.kumasi.debtmonkey.web.listitem.AccountListItem;
import com.kumasi.debtmonkey.web.listitem.AccountTypeListItem;

/**
 * Spring MVC controller for 'AccountAddress' management.
 */
@Controller
@RequestMapping("/accountAddress")
public class AccountAddressController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "accountAddress";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "accountAddress/form";
	private static final String JSP_LIST   = "accountAddress/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/accountAddress/create";
	private static final String SAVE_ACTION_UPDATE   = "/accountAddress/update";

	//--- Main entity service
	@Resource
    private AccountAddressService accountAddressService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private AddressTypeService addressTypeService; // Injected by Spring
	@Resource
    private AccountService accountService; // Injected by Spring
	@Resource
    private AccountTypeService accountTypeService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public AccountAddressController() {
		super(AccountAddressController.class, MAIN_ENTITY_NAME );
		log("AccountAddressController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
	/**
	 * Populates the combo-box "items" for the referenced entity "AddressType"
	 * @param model
	 */
	private void populateListOfAddressTypeItems(Model model) {
		List<AddressType> list = addressTypeService.findAll();
		List<AddressTypeListItem> items = new LinkedList<AddressTypeListItem>();
		for ( AddressType addressType : list ) {
			items.add(new AddressTypeListItem( addressType ) );
		}
		model.addAttribute("listOfAddressTypeItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "Account"
	 * @param model
	 */
	private void populateListOfAccountItems(Model model) {
		List<Account> list = accountService.findAll();
		List<AccountListItem> items = new LinkedList<AccountListItem>();
		for ( Account account : list ) {
			items.add(new AccountListItem( account ) );
		}
		model.addAttribute("listOfAccountItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "AccountType"
	 * @param model
	 */
	private void populateListOfAccountTypeItems(Model model) {
		List<AccountType> list = accountTypeService.findAll();
		List<AccountTypeListItem> items = new LinkedList<AccountTypeListItem>();
		for ( AccountType accountType : list ) {
			items.add(new AccountTypeListItem( accountType ) );
		}
		model.addAttribute("listOfAccountTypeItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param accountAddress
	 */
	private void populateModel(Model model, AccountAddress accountAddress, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, accountAddress);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfAddressTypeItems(model);
			populateListOfAccountItems(model);
			populateListOfAccountTypeItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfAccountItems(model);
			populateListOfAccountTypeItems(model);
			populateListOfAddressTypeItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of AccountAddress found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<AccountAddress> list = accountAddressService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new AccountAddress
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		AccountAddress accountAddress = new AccountAddress();	
		populateModel( model, accountAddress, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing AccountAddress
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		AccountAddress accountAddress = accountAddressService.findById(id);
		populateModel( model, accountAddress, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param accountAddress  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid AccountAddress accountAddress, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				AccountAddress accountAddressCreated = accountAddressService.create(accountAddress); 
				model.addAttribute(MAIN_ENTITY_NAME, accountAddressCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, accountAddress.getId() );
			} else {
				populateModel( model, accountAddress, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "accountAddress.error.create", e);
			populateModel( model, accountAddress, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param accountAddress  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid AccountAddress accountAddress, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				AccountAddress accountAddressSaved = accountAddressService.update(accountAddress);
				model.addAttribute(MAIN_ENTITY_NAME, accountAddressSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, accountAddress.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, accountAddress, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "accountAddress.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, accountAddress, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id) {
		log("Action 'delete'" );
		try {
			accountAddressService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "accountAddress.error.delete", e);
		}
		return redirectToList();
	}

}
