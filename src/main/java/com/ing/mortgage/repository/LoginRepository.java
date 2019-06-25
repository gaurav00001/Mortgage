package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Customer;
@Repository
public interface LoginRepository extends JpaRepository<Customer, Long> {
	
public  Customer findByLoginIdAndPassword(String loginId,String password);
}
