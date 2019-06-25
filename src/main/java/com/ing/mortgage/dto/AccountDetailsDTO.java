package com.ing.mortgage.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int balance;
	private Long accountNumber;
	private String accountType;

}
