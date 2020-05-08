package com.clover.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clover.spring.datajpa.model.Subscriptiondetails;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscriptiondetails,Integer> {
	
	

}
