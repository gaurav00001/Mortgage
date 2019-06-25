package com.ing.mortgage.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.MortgageDTO;
import com.ing.mortgage.service.MortgageSignUpService;
@RestController
@CrossOrigin(allowedHeaders = {"*","*/"},origins = {"*","*/"})
@RequestMapping("/api")
public class MortgagaeSignUpController {
	
@Autowired MortgageSignUpService mortgageSignUpService;

@PostMapping("/registration")
public ResponseEntity<MortgageDTO> signUp(@RequestBody MortgageDTO mortgageDTO){
	MortgageDTO mortgageDTOs= mortgageSignUpService.signUp(mortgageDTO);
		/*
		 * LocalDate dateOfBirth = mortgageDTO.getDob(); LocalDate currentDate =
		 * LocalDate.now(); Period age = Period.between(currentDate, dateOfBirth);
		 * System.out.println(age.getYears());
		 */
	
 return new  ResponseEntity<MortgageDTO>(mortgageDTOs,HttpStatus.OK);
}


}
