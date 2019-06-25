package com.ing.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	/* public List<Account> findByCustomerId(Integer id); */
	
	@Query("SELECT u FROM Account u WHERE u.customer.customerId = :id")
	public List<Account> showCustomerId(@Param ("id")Long customerId);
	
}
