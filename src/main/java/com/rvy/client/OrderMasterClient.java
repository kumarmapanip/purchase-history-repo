package com.rvy.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rvy.model.OrderDetail;
import com.rvy.model.OrderMaster;

@FeignClient(name = "rvy-order-service")
public interface OrderMasterClient {

	@GetMapping("rvy/api/oms/v1/orders/{id}")
	public OrderMaster getOrderDetail(@PathVariable("id") Integer id);
}
