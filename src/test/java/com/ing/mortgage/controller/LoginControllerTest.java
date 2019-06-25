package com.ing.mortgage.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.dto.LoginDetailsDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.service.LoginService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	LoginService loginService;

	@Test
	public void getLogin() throws Exception {
		Customer customer = new Customer();
		LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
		LoginDTO loginDTO = new LoginDTO();
		loginDetailsDTO.setCustomerId(1L);
		loginDetailsDTO.setMessage("Login Successfull");
		Mockito.when(loginService.validateLogin(loginDTO)).thenReturn(loginDetailsDTO);

		mockMvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
				.andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}

	}

}
