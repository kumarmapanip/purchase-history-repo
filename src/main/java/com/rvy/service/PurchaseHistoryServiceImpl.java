package com.rvy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rvy.entity.PurchaseHistory;
import com.rvy.repository.PurchaseHistoryRepo;

@Service
@Transactional
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService{

	@Autowired
	PurchaseHistoryRepo phRepo;
	
	@Override
	public List<PurchaseHistory> getAllPurchaseHistory() {
		return phRepo.findAll();
	}


	@Override
	public PurchaseHistory addElement(PurchaseHistory obj) {	
		return phRepo.save(obj);
	}

	@Override
	public List<PurchaseHistory> findDetailsByCustomerId(Integer customerId) {
		return 
				/*				phRepo.findAll().stream().filter((phd)->
				phd.getCustomerDetail().getCustomerId().equals(customerId)).findAny().orElse(null);
				 	*/
				
			phRepo.findAll().stream().filter((ph)->ph.getCustomerDetail().getCustomerId().equals(customerId))
			.collect(Collectors.toList());
	}

	@Override
	public PurchaseHistory getPurchaseHistoryById(String id) {
		return phRepo.findById(id).get();
	}

}
