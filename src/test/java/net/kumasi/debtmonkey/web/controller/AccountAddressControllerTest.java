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
import net.kumasi.debtmonkey.domain.AccountAddress;
import net.kumasi.debtmonkey.domain.AddressType;
import net.kumasi.debtmonkey.test.AccountAddressFactoryForTest;
import net.kumasi.debtmonkey.test.AddressTypeFactoryForTest;

//--- Services 
import net.kumasi.debtmonkey.business.service.AccountAddressService;
import net.kumasi.debtmonkey.business.service.AddressTypeService;

//--- List Items 
import net.kumasi.debtmonkey.web.listitem.AddressTypeListItem;

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
public class AccountAddressControllerTest {
	
	@InjectMocks
	private AccountAddressController accountAddressController;
	@Mock
	private AccountAddressService accountAddressService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AddressTypeService addressTypeService; // Injected by Spring

	private AccountAddressFactoryForTest accountAddressFactoryForTest = new AccountAddressFactoryForTest();
	private AddressTypeFactoryForTest addressTypeFactoryForTest = new AddressTypeFactoryForTest();

	List<AddressType> addressTypes = new ArrayList<AddressType>();

	private void givenPopulateModel() {
		AddressType addressType1 = addressTypeFactoryForTest.newAddressType();
		AddressType addressType2 = addressTypeFactoryForTest.newAddressType();
		List<AddressType> addressTypes = new ArrayList<AddressType>();
		addressTypes.add(addressType1);
		addressTypes.add(addressType2);
		when(addressTypeService.findAll()).thenReturn(addressTypes);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AccountAddress> list = new ArrayList<AccountAddress>();
		when(accountAddressService.findAll()).thenReturn(list);
		
		// When
		String viewName = accountAddressController.list(model);
		
		// Then
		assertEquals("accountAddress/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = accountAddressController.formForCreate(model);
		
		// Then
		assertEquals("accountAddress/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AccountAddress)modelMap.get("accountAddress")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/accountAddress/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AddressTypeListItem> addressTypeListItems = (List<AddressTypeListItem>) modelMap.get("listOfAddressTypeItems");
		assertEquals(2, addressTypeListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		Integer id = accountAddress.getId();
		when(accountAddressService.findById(id)).thenReturn(accountAddress);
		
		// When
		String viewName = accountAddressController.formForUpdate(model, id);
		
		// Then
		assertEquals("accountAddress/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddress, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/accountAddress/update", modelMap.get("saveAction"));
		
		List<AddressTypeListItem> addressTypeListItems = (List<AddressTypeListItem>) modelMap.get("listOfAddressTypeItems");
		assertEquals(2, addressTypeListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AccountAddress accountAddressCreated = new AccountAddress();
		when(accountAddressService.create(accountAddress)).thenReturn(accountAddressCreated); 
		
		// When
		String viewName = accountAddressController.create(accountAddress, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/accountAddress/form/"+accountAddress.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddressCreated, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = accountAddressController.create(accountAddress, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("accountAddress/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddress, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/accountAddress/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AddressTypeListItem> addressTypeListItems = (List<AddressTypeListItem>) modelMap.get("listOfAddressTypeItems");
		assertEquals(2, addressTypeListItems.size());
		
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

		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		
		Exception exception = new RuntimeException("test exception");
		when(accountAddressService.create(accountAddress)).thenThrow(exception);
		
		// When
		String viewName = accountAddressController.create(accountAddress, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("accountAddress/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddress, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/accountAddress/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "accountAddress.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AddressTypeListItem> addressTypeListItems = (List<AddressTypeListItem>) modelMap.get("listOfAddressTypeItems");
		assertEquals(2, addressTypeListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		Integer id = accountAddress.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AccountAddress accountAddressSaved = new AccountAddress();
		accountAddressSaved.setId(id);
		when(accountAddressService.update(accountAddress)).thenReturn(accountAddressSaved); 
		
		// When
		String viewName = accountAddressController.update(accountAddress, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/accountAddress/form/"+accountAddress.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddressSaved, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = accountAddressController.update(accountAddress, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("accountAddress/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddress, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/accountAddress/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AddressTypeListItem> addressTypeListItems = (List<AddressTypeListItem>) modelMap.get("listOfAddressTypeItems");
		assertEquals(2, addressTypeListItems.size());
		
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

		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		
		Exception exception = new RuntimeException("test exception");
		when(accountAddressService.update(accountAddress)).thenThrow(exception);
		
		// When
		String viewName = accountAddressController.update(accountAddress, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("accountAddress/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(accountAddress, (AccountAddress) modelMap.get("accountAddress"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/accountAddress/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "accountAddress.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AddressTypeListItem> addressTypeListItems = (List<AddressTypeListItem>) modelMap.get("listOfAddressTypeItems");
		assertEquals(2, addressTypeListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		Integer id = accountAddress.getId();
		
		// When
		String viewName = accountAddressController.delete(redirectAttributes, id);
		
		// Then
		verify(accountAddressService).delete(id);
		assertEquals("redirect:/accountAddress", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AccountAddress accountAddress = accountAddressFactoryForTest.newAccountAddress();
		Integer id = accountAddress.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(accountAddressService).delete(id);
		
		// When
		String viewName = accountAddressController.delete(redirectAttributes, id);
		
		// Then
		verify(accountAddressService).delete(id);
		assertEquals("redirect:/accountAddress", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "accountAddress.error.delete", exception);
	}
	
	
}
