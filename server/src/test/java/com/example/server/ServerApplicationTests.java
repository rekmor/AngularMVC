package com.example.server;

import com.example.server.repository.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest
@SpringBootTest
public class ServerApplicationTests {

	@Autowired
	MockMvc mockMvs;

	@MockBean
	UsersRepository usersRepository;

	@Test
	public void contextLoads() throws Exception {

		Mockito.when(usersRepository.findAll()).thenReturn(
				Collections.emptyList()
		);

		MvcResult mvcResult = mockMvs.perform(
				MockMvcRequestBuilders.get("/Users")
					.accept(MediaType.APPLICATION_JSON)
		).andReturn();

		System.out.print(mvcResult.getResponse());

		Mockito.verify(usersRepository).findAll();
	}

}
