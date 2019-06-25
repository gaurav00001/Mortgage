
package com.ing.mortgage.service;

import java.util.Date;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.MortgageDTO;
import com.ing.mortgage.entity.Account;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.entity.Transaction;
import com.ing.mortgage.repository.AccountRepository;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.MortgageRepository;
import com.ing.mortgage.repository.TransactionRepository;

@Service

@Transactional
public class MortgageSignUpServiceImpl implements MortgageSignUpService {

	@Autowired
	MortgageRepository mortgageRepository;
	@Autowired 
	CustomerRepository customerRepository;
	@Autowired 
	
	AccountRepository accountRepository;
	@Autowired 
	TransactionRepository transactionRespository;

	public MortgageDTO signUp(MortgageDTO mortgageDTO) {
		
		Mortgage mortage = new Mortgage();
		mortage.setOperationType(mortgageDTO.getOperationType());
		mortage.setPropertyCost(mortgageDTO.getPropertyCost());
		mortage.setDeposit(mortgageDTO.getDeposit());
		mortage.setEmploymentStatus(mortgageDTO.getEmploymentStatus());
		mortage.setOccupation(mortgageDTO.getOccupation());
		mortage.setContractType(mortgageDTO.getContractType());

		mortage.setJobStartDate(mortgageDTO.getJobStartDate());
		mortage.setTitle(mortgageDTO.getTitle());
		mortage.setFirstName(mortgageDTO.getFirstName());
		mortage.setMiddleName(mortgageDTO.getMiddleName());
		mortage.setSurname(mortgageDTO.getSurname());
		mortage.setPhoneNumber(mortgageDTO.getPhoneNumber());
		mortage.setDob(mortgageDTO.getDob());
		mortage.setEmail(mortgageDTO.getEmail());
		mortage.setCheckEmail(mortgageDTO.getCheckEmail());
		
		mortgageRepository.save(mortage);
		MortgageDTO mortgagedto = new MortgageDTO();

		Customer customer = new Customer();
		Random rand = new Random();

		Long id = 10000L + rand.nextInt(999999);
		Long passcode = 1000000L + rand.nextInt(9999999);

		String longId = String.valueOf(id);
		String password = String.valueOf(passcode);
		customer.setLoginId(longId);
		customer.setPassword(password);
		customer.setMortgage(mortage);
		customer = customerRepository.save(customer);
		mortage.setCustomer(customer);
		
		
		int transactionBalance= (int) (mortage.getPropertyCost()-mortage.getDeposit());
		int mortgageBalane=(int)(-(mortage.getPropertyCost()-mortage.getDeposit()));
		
		Account account = new Account();
		Long accountNumber=10000000000L+rand.nextInt(9999999);
		
		account.setAccountType("transactional account");
		account.setBalance(transactionBalance);
		account.setAccountNumber(accountNumber);
		account.setCustomer(customer);
		Transaction transaction=new Transaction();
		transaction.setBalance(account.getBalance()-200);
		Date cuurentDate=new Date();
		transaction.setDate(cuurentDate);
		transaction.setAccountType(account.getAccountType());	
		transaction.setDebitOrCredit("Debited");
		transaction.setDescription("Send to pay my mortgagae");
		transaction.setAccount(account);
		transactionRespository.save(transaction);
		accountRepository.save(account);

		Account account2=new Account();
		account2.setAccountType("Mortgage account");
		account2.setBalance(mortgageBalane);
		account2.setAccountNumber(accountNumber);
		account2.setCustomer(customer);
		accountRepository.save(account2);

		Transaction transaction2=new Transaction();
		transaction2.setBalance(account2.getBalance()+200);
		transaction2.setDate(cuurentDate);
		transaction2.setAccountType(account.getAccountType());	
		transaction2.setDebitOrCredit("Credited");
		transaction2.setDescription("Send to pay my mortgagae");
		transaction2.setAccount(account);
		transactionRespository.save(transaction2);
	
		
		BeanUtils.copyProperties(mortage, mortgagedto);
		return mortgagedto;
	}

}
