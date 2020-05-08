package com.clover.spring.datajpa.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clover.spring.datajpa.ExceptionHandling.LoanNotFound;
import com.clover.spring.datajpa.model.Loan;
import com.clover.spring.datajpa.model.Subscriptiondetails;
import com.clover.spring.datajpa.repository.LoanRepository;

@Service
@Transactional
public class LoanService {
	
	Logger logger = LoggerFactory.getLogger(LoanService.class);
	
	@Autowired
	private LoanRepository repo;

	public List<Loan> listAll() {
		if(repo.findAll().isEmpty()){
			logger.info("___________________");
			throw new LoanNotFound("No result to display");
		}
      return repo.findAll();
      
      //return repository.findById(id).orElseThrow(() -> new MyItemNotFoundException(id));
	}
	
	 public void save(Loan sd) {
	        repo.save(sd);
	    }
	
	
	
	

}
