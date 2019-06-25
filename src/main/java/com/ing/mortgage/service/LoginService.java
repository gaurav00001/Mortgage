package com.ing.mortgage.service;

import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.dto.LoginDetailsDTO;
import com.ing.mortgage.exception.UserNotFoundException;

public interface LoginService {
	public LoginDetailsDTO validateLogin(LoginDTO loginDTO) throws UserNotFoundException;

}
