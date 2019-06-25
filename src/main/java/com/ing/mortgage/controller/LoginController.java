package com.ing.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.dto.LoginDetailsDTO;
import com.ing.mortgage.exception.UserNotFoundException;
import com.ing.mortgage.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })


public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginDetailsDTO> validaetLogin(@RequestBody LoginDTO LoginDTO) throws UserNotFoundException {

		LoginDetailsDTO loginDetailsDTO = loginService.validateLogin(LoginDTO);
		return new ResponseEntity<>(loginDetailsDTO, HttpStatus.OK);
	}
}



