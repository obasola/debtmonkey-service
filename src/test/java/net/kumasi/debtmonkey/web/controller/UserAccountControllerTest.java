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
import net.kumasi.debtmonkey.domain.UserAccount;
import net.kumasi.debtmonkey.test.UserAccountFactoryForTest;

//--- Services 
import net.kumasi.debtmonkey.business.service.UserAccountService;


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
public class UserAccountControllerTest {
	
	@InjectMocks
	private UserAccountController userAccountController;
	@Mock
	private UserAccountService userAccountService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private UserAccountFactoryForTest userAccountFactoryForTest = new UserAccountFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<UserAccount> list = new ArrayList<UserAccount>();
		when(userAccountService.findAll()).thenReturn(list);
		
		// When
		String viewName = userAccountController.list(model);
		
		// Then
		assertEquals("userAccount/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = userAccountController.formForCreate(model);
		
		// Then
		assertEquals("userAccount/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((UserAccount)modelMap.get("userAccount")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/userAccount/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		Integer id = userAccount.getId();
		when(userAccountService.findById(id)).thenReturn(userAccount);
		
		// When
		String viewName = userAccountController.formForUpdate(model, id);
		
		// Then
		assertEquals("userAccount/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccount, (UserAccount) modelMap.get("userAccount"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/userAccount/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		UserAccount userAccountCreated = new UserAccount();
		when(userAccountService.create(userAccount)).thenReturn(userAccountCreated); 
		
		// When
		String viewName = userAccountController.create(userAccount, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/userAccount/form/"+userAccount.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccountCreated, (UserAccount) modelMap.get("userAccount"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = userAccountController.create(userAccount, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userAccount/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccount, (UserAccount) modelMap.get("userAccount"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/userAccount/create", modelMap.get("saveAction"));
		
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

		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		
		Exception exception = new RuntimeException("test exception");
		when(userAccountService.create(userAccount)).thenThrow(exception);
		
		// When
		String viewName = userAccountController.create(userAccount, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userAccount/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccount, (UserAccount) modelMap.get("userAccount"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/userAccount/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "userAccount.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		Integer id = userAccount.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		UserAccount userAccountSaved = new UserAccount();
		userAccountSaved.setId(id);
		when(userAccountService.update(userAccount)).thenReturn(userAccountSaved); 
		
		// When
		String viewName = userAccountController.update(userAccount, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/userAccount/form/"+userAccount.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccountSaved, (UserAccount) modelMap.get("userAccount"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = userAccountController.update(userAccount, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userAccount/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccount, (UserAccount) modelMap.get("userAccount"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/userAccount/update", modelMap.get("saveAction"));
		
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

		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		
		Exception exception = new RuntimeException("test exception");
		when(userAccountService.update(userAccount)).thenThrow(exception);
		
		// When
		String viewName = userAccountController.update(userAccount, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userAccount/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userAccount, (UserAccount) modelMap.get("userAccount"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/userAccount/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "userAccount.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		Integer id = userAccount.getId();
		
		// When
		String viewName = userAccountController.delete(redirectAttributes, id);
		
		// Then
		verify(userAccountService).delete(id);
		assertEquals("redirect:/userAccount", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		UserAccount userAccount = userAccountFactoryForTest.newUserAccount();
		Integer id = userAccount.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(userAccountService).delete(id);
		
		// When
		String viewName = userAccountController.delete(redirectAttributes, id);
		
		// Then
		verify(userAccountService).delete(id);
		assertEquals("redirect:/userAccount", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "userAccount.error.delete", exception);
	}
	
	
}
