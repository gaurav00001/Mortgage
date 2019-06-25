package com.ing.mortgage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginDetailsDTO {

	private Long customerId;
	private String message;
}
