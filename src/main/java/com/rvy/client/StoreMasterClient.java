package com.rvy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rvy.model.Store;

@FeignClient(name = "rvy-user-service")
public interface StoreMasterClient {
	
	@GetMapping("/rvy/um/v1/store/{storeId}")
	public Store getStorefromId(@PathVariable("storeId") Integer storeId);
}
