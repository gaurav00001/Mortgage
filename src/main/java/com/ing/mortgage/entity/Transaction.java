package com.ing.mortgage.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Transaction")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long transactionId;

	private int balance;
	private String accountType;

	private String debitOrCredit;
	private Date date;
	private String description;
	@ManyToOne
	@JoinColumn(name="accountId")
	private Account account;
}
