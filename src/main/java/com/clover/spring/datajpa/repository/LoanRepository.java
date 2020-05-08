package com.clover.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clover.spring.datajpa.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	
	

}
