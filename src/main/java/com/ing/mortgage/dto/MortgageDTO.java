package com.ing.mortgage.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString
public class MortgageDTO {

	private String operationType;
	private int propertyCost;
	private Long deposit;
	private String employmentStatus;
	private String occupation;
	private String contractType;
	private Date jobStartDate;
	private String title;
	private String firstName;
	private String middleName;
	private String surname;
	private Date dob;
	private int phoneNumber;
	private String email;
	private String CheckEmail;

}
