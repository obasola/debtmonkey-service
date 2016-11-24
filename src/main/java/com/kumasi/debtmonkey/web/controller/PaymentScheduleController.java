/*
 * Created on 23 Nov 2016 ( Time 15:22:17 )
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
import com.kumasi.debtmonkey.model.PaymentSchedule;
import com.kumasi.debtmonkey.model.Account;

//--- Services 
import com.kumasi.debtmonkey.business.service.PaymentScheduleService;
import com.kumasi.debtmonkey.business.service.AccountService;

//--- List Items 
import com.kumasi.debtmonkey.web.listitem.AccountListItem;

/**
 * Spring MVC controller for 'PaymentSchedule' management.
 */
@Controller
@RequestMapping("/paymentSchedule")
public class PaymentScheduleController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "paymentSchedule";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "paymentSchedule/form";
	private static final String JSP_LIST   = "paymentSchedule/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/paymentSchedule/create";
	private static final String SAVE_ACTION_UPDATE   = "/paymentSchedule/update";

	//--- Main entity service
	@Resource
    private PaymentScheduleService paymentScheduleService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private AccountService accountService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public PaymentScheduleController() {
		super(PaymentScheduleController.class, MAIN_ENTITY_NAME );
		log("PaymentScheduleController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
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
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param paymentSchedule
	 */
	private void populateModel(Model model, PaymentSchedule paymentSchedule, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, paymentSchedule);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfAccountItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfAccountItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of PaymentSchedule found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<PaymentSchedule> list = paymentScheduleService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new PaymentSchedule
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		PaymentSchedule paymentSchedule = new PaymentSchedule();	
		populateModel( model, paymentSchedule, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing PaymentSchedule
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		PaymentSchedule paymentSchedule = paymentScheduleService.findById(id);
		populateModel( model, paymentSchedule, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param paymentSchedule  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid PaymentSchedule paymentSchedule, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				PaymentSchedule paymentScheduleCreated = paymentScheduleService.create(paymentSchedule); 
				model.addAttribute(MAIN_ENTITY_NAME, paymentScheduleCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, paymentSchedule.getId() );
			} else {
				populateModel( model, paymentSchedule, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "paymentSchedule.error.create", e);
			populateModel( model, paymentSchedule, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param paymentSchedule  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid PaymentSchedule paymentSchedule, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				PaymentSchedule paymentScheduleSaved = paymentScheduleService.update(paymentSchedule);
				model.addAttribute(MAIN_ENTITY_NAME, paymentScheduleSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, paymentSchedule.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, paymentSchedule, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "paymentSchedule.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, paymentSchedule, FormMode.UPDATE);
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
			paymentScheduleService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "paymentSchedule.error.delete", e);
		}
		return redirectToList();
	}

}
