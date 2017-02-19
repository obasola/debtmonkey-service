package net.kumasi.debtmonkey.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//--- Entities
import net.kumasi.debtmonkey.domain.PaymentSchedule;
import net.kumasi.debtmonkey.domain.Account;
import net.kumasi.debtmonkey.test.PaymentScheduleFactoryForTest;
import net.kumasi.debtmonkey.test.AccountFactoryForTest;

//--- Services 
import net.kumasi.debtmonkey.business.service.PaymentScheduleService;
import net.kumasi.debtmonkey.business.service.AccountService;

//--- List Items 
import net.kumasi.debtmonkey.web.listitem.AccountListItem;

import net.kumasi.debtmonkey.web.common.Message;
import net.kumasi.debtmonkey.web.common.MessageHelper;
import net.kumasi.debtmonkey.web.common.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class PaymentScheduleControllerTest {
	
	@InjectMocks
	private PaymentScheduleController paymentScheduleController;
	@Mock
	private PaymentScheduleService paymentScheduleService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AccountService accountService; // Injected by Spring

	private PaymentScheduleFactoryForTest paymentScheduleFactoryForTest = new PaymentScheduleFactoryForTest();
	private AccountFactoryForTest accountFactoryForTest = new AccountFactoryForTest();

	List<Account> accounts = new ArrayList<Account>();

	private void givenPopulateModel() {
		Account account1 = accountFactoryForTest.newAccount();
		Account account2 = accountFactoryForTest.newAccount();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		when(accountService.findAll()).thenReturn(accounts);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<PaymentSchedule> list = new ArrayList<PaymentSchedule>();
		when(paymentScheduleService.findAll()).thenReturn(list);
		
		// When
		String viewName = paymentScheduleController.list(model);
		
		// Then
		assertEquals("paymentSchedule/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = paymentScheduleController.formForCreate(model);
		
		// Then
		assertEquals("paymentSchedule/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((PaymentSchedule)modelMap.get("paymentSchedule")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/paymentSchedule/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AccountListItem> accountListItems = (List<AccountListItem>) modelMap.get("listOfAccountItems");
		assertEquals(2, accountListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		Integer id = paymentSchedule.getId();
		when(paymentScheduleService.findById(id)).thenReturn(paymentSchedule);
		
		// When
		String viewName = paymentScheduleController.formForUpdate(model, id);
		
		// Then
		assertEquals("paymentSchedule/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentSchedule, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/paymentSchedule/update", modelMap.get("saveAction"));
		
		List<AccountListItem> accountListItems = (List<AccountListItem>) modelMap.get("listOfAccountItems");
		assertEquals(2, accountListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		PaymentSchedule paymentScheduleCreated = new PaymentSchedule();
		when(paymentScheduleService.create(paymentSchedule)).thenReturn(paymentScheduleCreated); 
		
		// When
		String viewName = paymentScheduleController.create(paymentSchedule, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/paymentSchedule/form/"+paymentSchedule.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentScheduleCreated, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = paymentScheduleController.create(paymentSchedule, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("paymentSchedule/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentSchedule, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/paymentSchedule/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AccountListItem> accountListItems = (List<AccountListItem>) modelMap.get("listOfAccountItems");
		assertEquals(2, accountListItems.size());
		
	}

	@Test
	public void createException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		
		Exception exception = new RuntimeException("test exception");
		when(paymentScheduleService.create(paymentSchedule)).thenThrow(exception);
		
		// When
		String viewName = paymentScheduleController.create(paymentSchedule, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("paymentSchedule/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentSchedule, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/paymentSchedule/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "paymentSchedule.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AccountListItem> accountListItems = (List<AccountListItem>) modelMap.get("listOfAccountItems");
		assertEquals(2, accountListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		Integer id = paymentSchedule.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		PaymentSchedule paymentScheduleSaved = new PaymentSchedule();
		paymentScheduleSaved.setId(id);
		when(paymentScheduleService.update(paymentSchedule)).thenReturn(paymentScheduleSaved); 
		
		// When
		String viewName = paymentScheduleController.update(paymentSchedule, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/paymentSchedule/form/"+paymentSchedule.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentScheduleSaved, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = paymentScheduleController.update(paymentSchedule, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("paymentSchedule/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentSchedule, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/paymentSchedule/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AccountListItem> accountListItems = (List<AccountListItem>) modelMap.get("listOfAccountItems");
		assertEquals(2, accountListItems.size());
		
	}

	@Test
	public void updateException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		
		Exception exception = new RuntimeException("test exception");
		when(paymentScheduleService.update(paymentSchedule)).thenThrow(exception);
		
		// When
		String viewName = paymentScheduleController.update(paymentSchedule, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("paymentSchedule/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(paymentSchedule, (PaymentSchedule) modelMap.get("paymentSchedule"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/paymentSchedule/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "paymentSchedule.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AccountListItem> accountListItems = (List<AccountListItem>) modelMap.get("listOfAccountItems");
		assertEquals(2, accountListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		Integer id = paymentSchedule.getId();
		
		// When
		String viewName = paymentScheduleController.delete(redirectAttributes, id);
		
		// Then
		verify(paymentScheduleService).delete(id);
		assertEquals("redirect:/paymentSchedule", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		PaymentSchedule paymentSchedule = paymentScheduleFactoryForTest.newPaymentSchedule();
		Integer id = paymentSchedule.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(paymentScheduleService).delete(id);
		
		// When
		String viewName = paymentScheduleController.delete(redirectAttributes, id);
		
		// Then
		verify(paymentScheduleService).delete(id);
		assertEquals("redirect:/paymentSchedule", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "paymentSchedule.error.delete", exception);
	}
	
	
}
