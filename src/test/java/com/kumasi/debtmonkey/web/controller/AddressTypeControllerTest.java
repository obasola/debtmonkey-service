package com.kumasi.debtmonkey.web.controller;

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
import com.kumasi.debtmonkey.model.AddressType;
import com.kumasi.debtmonkey.test.AddressTypeFactoryForTest;

//--- Services 
import com.kumasi.debtmonkey.business.service.AddressTypeService;


import com.kumasi.debtmonkey.web.common.Message;
import com.kumasi.debtmonkey.web.common.MessageHelper;
import com.kumasi.debtmonkey.web.common.MessageType;
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
public class AddressTypeControllerTest {
	
	@InjectMocks
	private AddressTypeController addressTypeController;
	@Mock
	private AddressTypeService addressTypeService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AddressTypeFactoryForTest addressTypeFactoryForTest = new AddressTypeFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AddressType> list = new ArrayList<AddressType>();
		when(addressTypeService.findAll()).thenReturn(list);
		
		// When
		String viewName = addressTypeController.list(model);
		
		// Then
		assertEquals("addressType/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = addressTypeController.formForCreate(model);
		
		// Then
		assertEquals("addressType/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AddressType)modelMap.get("addressType")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/addressType/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		Integer id = addressType.getId();
		when(addressTypeService.findById(id)).thenReturn(addressType);
		
		// When
		String viewName = addressTypeController.formForUpdate(model, id);
		
		// Then
		assertEquals("addressType/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressType, (AddressType) modelMap.get("addressType"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/addressType/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AddressType addressTypeCreated = new AddressType();
		when(addressTypeService.create(addressType)).thenReturn(addressTypeCreated); 
		
		// When
		String viewName = addressTypeController.create(addressType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/addressType/form/"+addressType.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressTypeCreated, (AddressType) modelMap.get("addressType"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = addressTypeController.create(addressType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("addressType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressType, (AddressType) modelMap.get("addressType"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/addressType/create", modelMap.get("saveAction"));
		
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

		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		
		Exception exception = new RuntimeException("test exception");
		when(addressTypeService.create(addressType)).thenThrow(exception);
		
		// When
		String viewName = addressTypeController.create(addressType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("addressType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressType, (AddressType) modelMap.get("addressType"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/addressType/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "addressType.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		Integer id = addressType.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AddressType addressTypeSaved = new AddressType();
		addressTypeSaved.setId(id);
		when(addressTypeService.update(addressType)).thenReturn(addressTypeSaved); 
		
		// When
		String viewName = addressTypeController.update(addressType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/addressType/form/"+addressType.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressTypeSaved, (AddressType) modelMap.get("addressType"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = addressTypeController.update(addressType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("addressType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressType, (AddressType) modelMap.get("addressType"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/addressType/update", modelMap.get("saveAction"));
		
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

		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		
		Exception exception = new RuntimeException("test exception");
		when(addressTypeService.update(addressType)).thenThrow(exception);
		
		// When
		String viewName = addressTypeController.update(addressType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("addressType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(addressType, (AddressType) modelMap.get("addressType"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/addressType/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "addressType.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		Integer id = addressType.getId();
		
		// When
		String viewName = addressTypeController.delete(redirectAttributes, id);
		
		// Then
		verify(addressTypeService).delete(id);
		assertEquals("redirect:/addressType", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AddressType addressType = addressTypeFactoryForTest.newAddressType();
		Integer id = addressType.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(addressTypeService).delete(id);
		
		// When
		String viewName = addressTypeController.delete(redirectAttributes, id);
		
		// Then
		verify(addressTypeService).delete(id);
		assertEquals("redirect:/addressType", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "addressType.error.delete", exception);
	}
	
	
}
