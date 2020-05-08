package com.clover.spring.datajpa.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clover.spring.datajpa.Services.SubscriptionService;
import com.clover.spring.datajpa.model.Subscriptiondetails;



@RestController
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService service;
	
	@GetMapping("/subscription")
	public List<Subscriptiondetails> list() {
	    return service.listAll();
	}
	
	@GetMapping("/subscription/{id}")
	public ResponseEntity<Subscriptiondetails> get(@PathVariable Integer id) {
		try {
			Subscriptiondetails product = service.get(id);
			return new ResponseEntity<Subscriptiondetails>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Subscriptiondetails>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PostMapping("/insertSub")
	public ResponseEntity<Subscriptiondetails> add(@RequestBody Subscriptiondetails sd) {
	    service.save(sd);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("/updateSub/{id}")
	public ResponseEntity<?> update(@RequestBody Subscriptiondetails sd, @PathVariable Integer id) {
	    try {
	    	Subscriptiondetails sud = service.get(id);
	    	//sud.setModifiedDate(modifiedDate);
	        service.save(sd);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@RequestMapping(value= "/update/{id}", method= RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@RequestBody Subscriptiondetails updemp, @PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");
 
        Optional<Subscriptiondetails> emp =  service.getById(id);
        if (!emp.isPresent()){
        	System.out.println(this.getClass().getSimpleName() + " - Error employee details by id is invoked.");
        	throw new Exception("Could not find  with id- " + id);
        }
        	
            
 
       if(updemp.getSubscriptionName().isEmpty()){
    	   updemp.setSubscriptionName(emp.get().getSubscriptionName());
       }
       if(updemp.getSubscriptionValidityYears()==null){
    	   updemp.setSubscriptionValidityYears(emp.get().getSubscriptionValidityYears());
       }
       
       if(updemp.getSubscriptionValidityDays()==null){
    	   updemp.setSubscriptionValidityDays(emp.get().getSubscriptionValidityDays());
       }
       
       if(updemp.getBenificiaryCount()==null){
    	   updemp.setBenificiaryCount(emp.get().getBenificiaryCount());
       }
       if(updemp.getStatus().isEmpty()){
    	   updemp.setStatus(emp.get().getStatus());
       }
       if(updemp.getInsertedBy().isEmpty()){
    	   updemp.setInsertedBy(emp.get().getInsertedBy());
       }
       if(updemp.getInsertedDate()==null){
    	   updemp.setInsertedDate(emp.get().getInsertedDate());
       }
       
       if(updemp.getModifiedBy().isEmpty()){
    	   updemp.setModifiedBy(emp.get().getModifiedBy());
       }
       if(updemp.getRemarks().isEmpty()){
    	   updemp.setRemarks(emp.get().getRemarks());
         }
       java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
       
        updemp.setModifiedDate(date);
        updemp.setSubscriptionid(id);
        service.save(updemp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

	
	

}
