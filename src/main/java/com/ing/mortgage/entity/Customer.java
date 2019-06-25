package com.ing.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Customer")

@NoArgsConstructor

@Setter

@Getter

@ToString

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String loginId;
	private String password;
	private Long mortgageId;

}
