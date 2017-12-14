package com.example.server.Controller;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.server.controller.UsersController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.server.model.Users;
import com.example.server.Service.UsersService;
/**
 * Created by RekMor on 12/13/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = UsersController.class, secure = false)
public class UserControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsersService usersService;

	Users mockUser = new Users(2, "maclaren", "P1",1991,11222);

	String exampleUserJson = "{\"id\":\"1\",\"model\":\"P1\",\"price\"12232\"}";

	@Test
	public void retrieveUsers() throws Exception {

		Mockito.when(
				usersService.getAllUsers()).thenReturn((List<Users>) mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/Users/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:2,name:maclaren,model:P1,Year:1991, price:11222}";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	@Test
	public void createUser() throws Exception {


		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/Users/")
				.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/Users",
				response.getHeader(HttpHeaders.LOCATION));

	}

}
