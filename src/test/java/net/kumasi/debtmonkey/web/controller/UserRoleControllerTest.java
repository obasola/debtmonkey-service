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

//--- Services 
import net.kumasi.debtmonkey.business.service.UserRoleService;
//--- Entities
import net.kumasi.debtmonkey.domain.UserRole;
import net.kumasi.debtmonkey.test.UserRoleFactoryForTest;
import net.kumasi.debtmonkey.web.common.Message;
import net.kumasi.debtmonkey.web.common.MessageHelper;
import net.kumasi.debtmonkey.web.common.MessageType;

@RunWith(MockitoJUnitRunner.class)
public class UserRoleControllerTest {
	
	@InjectMocks
	private UserRoleController userRoleController;
	@Mock
	private UserRoleService userRoleService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private UserRoleFactoryForTest userRoleFactoryForTest = new UserRoleFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<UserRole> list = new ArrayList<UserRole>();
		when(userRoleService.findAll()).thenReturn(list);
		
		// When
		String viewName = userRoleController.list(model);
		
		// Then
		assertEquals("userRole/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = userRoleController.formForCreate(model);
		
		// Then
		assertEquals("userRole/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((UserRole)modelMap.get("userRole")).getUserAccount());
		assertNull(((UserRole)modelMap.get("userRole")).getRole());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/userRole/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		Integer userAccountId = userRole.getUserAccount().getId();
		Integer roleRoleId = userRole.getRole().getRoleId();
		when(userRoleService.findById(userAccountId, roleRoleId)).thenReturn(userRole);
		
		// When
		String viewName = userRoleController.formForUpdate(model, userAccountId, roleRoleId);
		
		// Then
		assertEquals("userRole/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRole, (UserRole) modelMap.get("userRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/userRole/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		UserRole userRoleCreated = new UserRole();
		when(userRoleService.create(userRole)).thenReturn(userRoleCreated); 
		
		// When
		String viewName = userRoleController.create(userRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/userRole/form/"+userRole.getUserAccount().getId()+"/"+userRole.getRole().getRoleId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRoleCreated, (UserRole) modelMap.get("userRole"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = userRoleController.create(userRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRole, (UserRole) modelMap.get("userRole"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/userRole/create", modelMap.get("saveAction"));
		
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

		UserRole userRole = userRoleFactoryForTest.newUserRole();
		
		Exception exception = new RuntimeException("test exception");
		when(userRoleService.create(userRole)).thenThrow(exception);
		
		// When
		String viewName = userRoleController.create(userRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRole, (UserRole) modelMap.get("userRole"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/userRole/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "userRole.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();

		Integer roleRoleId = userRole.getRole().getRoleId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		UserRole userRoleSaved = new UserRole();
		userRoleSaved.setUserAccount(userRole.getUserAccount());
		userRoleSaved.setRole(userRole.getRole());
		when(userRoleService.update(userRole)).thenReturn(userRoleSaved); 
		
		// When
		String viewName = userRoleController.update(userRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
	//	assertEquals("redirect:/userRole/form/"+userRole.getUserAccount()+"/"+userRole.getRole(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRoleSaved, (UserRole) modelMap.get("userRole"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = userRoleController.update(userRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRole, (UserRole) modelMap.get("userRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/userRole/update", modelMap.get("saveAction"));
		
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

		UserRole userRole = userRoleFactoryForTest.newUserRole();
		
		Exception exception = new RuntimeException("test exception");
		when(userRoleService.update(userRole)).thenThrow(exception);
		
		// When
		String viewName = userRoleController.update(userRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("userRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(userRole, (UserRole) modelMap.get("userRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/userRole/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "userRole.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		
		// When
		String viewName = userRoleController.delete(redirectAttributes, userRole.getUserAccount().getId(), userRole.getRole().getRoleId());
		
		// Then
		verify(userRoleService).delete( userRole.getUserAccount().getId(), userRole.getRole().getRoleId());
		assertEquals("redirect:/userRole", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		UserRole userRole = userRoleFactoryForTest.newUserRole();
		Integer userAccountId = userRole.getUserAccount().getId();
		Integer roleRoleId = userRole.getRole().getRoleId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(userRoleService).delete(userAccountId, roleRoleId);
		
		// When
		String viewName = userRoleController.delete(redirectAttributes, userAccountId, roleRoleId);
		
		// Then
		verify(userRoleService).delete(userAccountId, roleRoleId);
		assertEquals("redirect:/userRole", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "userRole.error.delete", exception);
	}
	
	
}
