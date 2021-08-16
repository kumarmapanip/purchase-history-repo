package com.rvy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.rvy.entity.PurchaseHistory;

@Repository
public interface PurchaseHistoryRepo extends MongoRepository<PurchaseHistory,String>{
	//public abstract PurchaseHistory findByCustomerId(Integer customerId); 
}
