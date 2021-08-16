package com.rvy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rvy.model.Customer;

@FeignClient(name = "rvy-customer-service")
public interface CustomerMasterClient {
	
	@GetMapping("/rvy/api/cm/v1/customers/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") Integer customerId);
}
