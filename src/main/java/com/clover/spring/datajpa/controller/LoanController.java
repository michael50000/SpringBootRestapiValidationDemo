package com.clover.spring.datajpa.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clover.spring.datajpa.Services.LoanService;
import com.clover.spring.datajpa.model.Loan;
import com.clover.spring.datajpa.model.Subscriptiondetails;

@RestController
public class LoanController {
	Logger logger = LoggerFactory.getLogger(LoanService.class);
	
	@Autowired
	private LoanService service;
	
	@RequestMapping("/api")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return "Howdy! Check out the Logs to see the output...";
    }
	
	
	@GetMapping("/loans")
	public List<Loan> list() {
	    return service.listAll();
	}
	
	@PostMapping("/insertLoan")
	 public void save(@RequestBody Loan sd) {
		logger.info("-----"+sd.getLoanName());
		//logger.info("**************"+sd.getLoanName()==null);
		//System.out.println(sd.getLoanName()==null);
		
		//Set<ConstraintViolation<User>> violations = validator.validate(user);
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Loan>> violations = validator.validate(sd);

		for (ConstraintViolation<Loan> violation : violations) {
			logger.error(violation.getMessage()); 
		}
		 service.save(sd);
	    }  */
		
		try {
			
		} catch (ConstraintViolationException e) {
			// TODO: handle exception
		}
	}
	
	
	

}
