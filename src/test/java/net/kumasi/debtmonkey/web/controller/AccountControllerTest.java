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
import net.kumasi.debtmonkey.domain.Account;
import net.kumasi.debtmonkey.domain.AccountAddress;
import net.kumasi.debtmonkey.domain.UserAccount;
import net.kumasi.debtmonkey.domain.AccountType;
import net.kumasi.debtmonkey.test.AccountFactoryForTest;
import net.kumasi.debtmonkey.test.AccountAddressFactoryForTest;
import net.kumasi.debtmonkey.test.UserAccountFactoryForTest;
import net.kumasi.debtmonkey.test.AccountTypeFactoryForTest;

//--- Services 
import net.kumasi.debtmonkey.business.service.AccountService;
import net.kumasi.debtmonkey.business.service.AccountAddressService;
import net.kumasi.debtmonkey.business.service.UserAccountService;
import net.kumasi.debtmonkey.business.service.AccountTypeService;

//--- List Items 
import net.kumasi.debtmonkey.web.listitem.AccountAddressListItem;
import net.kumasi.debtmonkey.web.listitem.UserAccountListItem;
import net.kumasi.debtmonkey.web.listitem.AccountTypeListItem;

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
public class AccountControllerTest {
	
	@InjectMocks
	private AccountController accountController;
	@Mock
	private AccountService accountService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AccountAddressService accountAddressService; // Injected by Spring
	@Mock
	private UserAccountService userAccountService; // Injected by Spring
	@Mock
	private AccountTypeService accountTypeService; // Injected by Spring

	private AccountFactoryForTest accountFactoryForTest = new AccountFactoryForTest();
	private AccountAddressFactoryForTest accountAddressFactoryForTest = new AccountAddressFactoryForTest();
	private UserAccountFactoryForTest userAccountFactoryForTest = new UserAccountFactoryForTest();
	private AccountTypeFactoryForTest accountTypeFactoryForTest = new AccountTypeFactoryForTest();

	List<AccountAddress> accountAddresss = new ArrayList<AccountAddress>();
	List<UserAccount> userAccounts = new ArrayList<UserAccount>();
	List<AccountType> accountTypes = new ArrayList<AccountType>();

	private void givenPopulateModel() {
		AccountAddress accountAddress1 = accountAddressFactoryForTest.newAccountAddress();
		AccountAddress accountAddress2 = accountAddressFactoryForTest.newAccountAddress();
		List<AccountAddress> accountAddresss = new ArrayList<AccountAddress>();
		accountAddresss.add(accountAddress1);
		accountAddresss.add(accountAddress2);
		when(accountAddressService.findAll()).thenReturn(accountAddresss);

		UserAccount userAccount1 = userAccountFactoryForTest.newUserAccount();
		UserAccount userAccount2 = userAccountFactoryForTest.newUserAccount();
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		userAccounts.add(userAccount1);
		userAccounts.add(userAccount2);
		when(userAccountService.findAll()).thenReturn(userAccounts);

		AccountType accountType1 = accountTypeFactoryForTest.newAccountType();
		AccountType accountType2 = accountTypeFactoryForTest.newAccountType();
		List<AccountType> accountTypes = new ArrayList<AccountType>();
		accountTypes.add(accountType1);
		accountTypes.add(accountType2);
		when(accountTypeService.findAll()).thenReturn(accountTypes);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Account> list = new ArrayList<Account>();
		when(accountService.findAll()).thenReturn(list);
		
		// When
		String viewName = accountController.list(model);
		
		// Then
		assertEquals("account/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = accountController.formForCreate(model);
		
		// Then
		assertEquals("account/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Account)modelMap.get("account")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/account/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AccountAddressListItem> accountAddressListItems = (List<AccountAddressListItem>) modelMap.get("listOfAccountAddressItems");
		assertEquals(2, accountAddressListItems.size());
		
		@SuppressWarnings("unchecked")
		List<UserAccountListItem> userAccountListItems = (List<UserAccountListItem>) modelMap.get("listOfUserAccountItems");
		assertEquals(2, userAccountListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AccountTypeListItem> accountTypeListItems = (List<AccountTypeListItem>) modelMap.get("listOfAccountTypeItems");
		assertEquals(2, accountTypeListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Account account = accountFactoryForTest.newAccount();
		Integer id = account.getId();
		when(accountService.findById(id)).thenReturn(account);
		
		// When
		String viewName = accountController.formForUpdate(model, id);
		
		// Then
		assertEquals("account/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(account, (Account) modelMap.get("account"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/account/update", modelMap.get("saveAction"));
		
		List<AccountTypeListItem> accountTypeListItems = (List<AccountTypeListItem>) modelMap.get("listOfAccountTypeItems");
		assertEquals(2, accountTypeListItems.size());
		
		List<UserAccountListItem> userAccountListItems = (List<UserAccountListItem>) modelMap.get("listOfUserAccountItems");
		assertEquals(2, userAccountListItems.size());
		
		List<AccountAddressListItem> accountAddressListItems = (List<AccountAddressListItem>) modelMap.get("listOfAccountAddressItems");
		assertEquals(2, accountAddressListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Account account = accountFactoryForTest.newAccount();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Account accountCreated = new Account();
		when(accountService.create(account)).thenReturn(accountCreated); 
		
		// When
		String viewName = accountController.create(account, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/account/form/"+account.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountCreated, (Account) modelMap.get("account"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Account account = accountFactoryForTest.newAccount();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = accountController.create(account, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("account/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(account, (Account) modelMap.get("account"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/account/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AccountAddressListItem> accountAddressListItems = (List<AccountAddressListItem>) modelMap.get("listOfAccountAddressItems");
		assertEquals(2, accountAddressListItems.size());
		
		@SuppressWarnings("unchecked")
		List<UserAccountListItem> userAccountListItems = (List<UserAccountListItem>) modelMap.get("listOfUserAccountItems");
		assertEquals(2, userAccountListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AccountTypeListItem> accountTypeListItems = (List<AccountTypeListItem>) modelMap.get("listOfAccountTypeItems");
		assertEquals(2, accountTypeListItems.size());
		
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

		Account account = accountFactoryForTest.newAccount();
		
		Exception exception = new RuntimeException("test exception");
		when(accountService.create(account)).thenThrow(exception);
		
		// When
		String viewName = accountController.create(account, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("account/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(account, (Account) modelMap.get("account"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/account/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "account.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AccountAddressListItem> accountAddressListItems = (List<AccountAddressListItem>) modelMap.get("listOfAccountAddressItems");
		assertEquals(2, accountAddressListItems.size());
		
		@SuppressWarnings("unchecked")
		List<UserAccountListItem> userAccountListItems = (List<UserAccountListItem>) modelMap.get("listOfUserAccountItems");
		assertEquals(2, userAccountListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AccountTypeListItem> accountTypeListItems = (List<AccountTypeListItem>) modelMap.get("listOfAccountTypeItems");
		assertEquals(2, accountTypeListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Account account = accountFactoryForTest.newAccount();
		Integer id = account.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Account accountSaved = new Account();
		accountSaved.setId(id);
		when(accountService.update(account)).thenReturn(accountSaved); 
		
		// When
		String viewName = accountController.update(account, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/account/form/"+account.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountSaved, (Account) modelMap.get("account"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Account account = accountFactoryForTest.newAccount();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = accountController.update(account, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("account/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(account, (Account) modelMap.get("account"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/account/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AccountTypeListItem> accountTypeListItems = (List<AccountTypeListItem>) modelMap.get("listOfAccountTypeItems");
		assertEquals(2, accountTypeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<UserAccountListItem> userAccountListItems = (List<UserAccountListItem>) modelMap.get("listOfUserAccountItems");
		assertEquals(2, userAccountListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AccountAddressListItem> accountAddressListItems = (List<AccountAddressListItem>) modelMap.get("listOfAccountAddressItems");
		assertEquals(2, accountAddressListItems.size());
		
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

		Account account = accountFactoryForTest.newAccount();
		
		Exception exception = new RuntimeException("test exception");
		when(accountService.update(account)).thenThrow(exception);
		
		// When
		String viewName = accountController.update(account, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("account/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(account, (Account) modelMap.get("account"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/account/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "account.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AccountTypeListItem> accountTypeListItems = (List<AccountTypeListItem>) modelMap.get("listOfAccountTypeItems");
		assertEquals(2, accountTypeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<UserAccountListItem> userAccountListItems = (List<UserAccountListItem>) modelMap.get("listOfUserAccountItems");
		assertEquals(2, userAccountListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AccountAddressListItem> accountAddressListItems = (List<AccountAddressListItem>) modelMap.get("listOfAccountAddressItems");
		assertEquals(2, accountAddressListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Account account = accountFactoryForTest.newAccount();
		Integer id = account.getId();
		
		// When
		String viewName = accountController.delete(redirectAttributes, id);
		
		// Then
		verify(accountService).delete(id);
		assertEquals("redirect:/account", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Account account = accountFactoryForTest.newAccount();
		Integer id = account.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(accountService).delete(id);
		
		// When
		String viewName = accountController.delete(redirectAttributes, id);
		
		// Then
		verify(accountService).delete(id);
		assertEquals("redirect:/account", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "account.error.delete", exception);
	}
	
	
}
