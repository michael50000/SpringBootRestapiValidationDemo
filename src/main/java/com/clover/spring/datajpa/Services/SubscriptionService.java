package com.clover.spring.datajpa.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clover.spring.datajpa.model.Subscriptiondetails;
import com.clover.spring.datajpa.repository.SubscriptionRepository;


@Service
@Transactional
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepository repo;
	
	
	
	public List<Subscriptiondetails> listAll() {
        return repo.findAll();
    }
     
    public void save(Subscriptiondetails sd) {
        repo.save(sd);
    }
     
    public Subscriptiondetails get(Integer id) {
        return repo.findById(id).get();
    }
    
    public Optional<Subscriptiondetails> getById(int id) {
        return repo.findById(id);
    }

}
