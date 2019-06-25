package com.ing.mortgage.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.dto.LoginDetailsDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.exception.UserNotFoundException;
import com.ing.mortgage.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	LoginRepository loginRepository;

	@Override
	@Transactional
	public LoginDetailsDTO validateLogin(LoginDTO loginDTO) throws UserNotFoundException {
		Customer customer = loginRepository.findByLoginIdAndPassword(loginDTO.getLoginId(), loginDTO.getPassword());

		logger.info(customer.toString());
		LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
		loginDetailsDTO.setCustomerId(customer.getCustomerId());
		// BeanUtils.copyProperties(customer, loginDetailsDTO);
		if (customer.getLoginId() != null) {
			loginDetailsDTO.setMessage("Login Successfull");
		} else {

			throw new UserNotFoundException("Invalid credentials");

		}
		return loginDetailsDTO;
	}

}
