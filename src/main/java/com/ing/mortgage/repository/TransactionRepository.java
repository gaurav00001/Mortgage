package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.mortgage.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	

}
