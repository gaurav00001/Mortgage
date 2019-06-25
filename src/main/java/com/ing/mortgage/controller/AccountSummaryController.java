package com.ing.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.AccountDetailsDTO;
import com.ing.mortgage.service.AccountService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class AccountSummaryController {
	
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/summary/{customerId}")
	public ResponseEntity<List<AccountDetailsDTO>> summary(@PathVariable Long customerId)
	{
		List<AccountDetailsDTO> accountDetailsDTOList=accountService.summary(customerId);
		
		return new ResponseEntity<>(accountDetailsDTOList,HttpStatus.OK);
		
	}

}
