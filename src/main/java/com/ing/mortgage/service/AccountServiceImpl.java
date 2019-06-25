package com.ing.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.AccountDetailsDTO;
import com.ing.mortgage.entity.Account;
import com.ing.mortgage.repository.AccountRepository;

@Service
public class AccountServiceImpl  implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public List<AccountDetailsDTO> summary(Long customerId) {

		
		
		List<AccountDetailsDTO> listAccountDetailDTO=new ArrayList<>();
		
		List<Account> accountList = accountRepository.showCustomerId(customerId);
		
		for (int i = 0; i < accountList.size(); i++) {
			AccountDetailsDTO accountDetailsDTO=new AccountDetailsDTO();
			accountDetailsDTO.setAccountNumber((long) accountList.get(i).getAccountId());
			accountDetailsDTO.setBalance(accountList.get(i).getBalance());
			accountDetailsDTO.setAccountType(accountList.get(i).getAccountType());
			
			listAccountDetailDTO.add(accountDetailsDTO);
		}
			
		System.out.println();
		
		
		return listAccountDetailDTO;
	}

}
