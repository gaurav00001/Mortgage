package com.ing.mortgage.service;

import java.util.List;

import com.ing.mortgage.dto.AccountDetailsDTO;

public interface AccountService {
	
	public List<AccountDetailsDTO> summary(Long customerId);

}
