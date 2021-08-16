package com.rvy.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rvy.model.Product;

@FeignClient(name = "rvy-product-service")
public interface ProductMasterClient {
	
	@GetMapping("/rvy/api/pis/v1//products/{listId}")
	public List<Product> getProdDetails(@PathVariable("listId") String listId);
}
