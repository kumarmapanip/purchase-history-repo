package com.rvy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.rvy.client.CustomerMasterClient;
import com.rvy.client.OrderMasterClient;
import com.rvy.client.ProductMasterClient;
import com.rvy.client.StoreMasterClient;
import com.rvy.entity.PurchaseHistory;
import com.rvy.model.Customer;
import com.rvy.model.OrderMaster;
import com.rvy.model.Product;
import com.rvy.model.Store;
import com.rvy.service.PurchaseHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/ph/v1")
@Api
public class PurchaseHistoryController {

	@Autowired
	PurchaseHistoryService purchaseHistoryService;

	@Autowired
	private OrderMasterClient orderClient;
	
	@Autowired
	private CustomerMasterClient customerClient;
	
	@Autowired 
	private ProductMasterClient productClient;
	
	@Autowired
	private StoreMasterClient storeClient;
	
	List<Integer> idDetailList=new ArrayList<Integer>();
	
	
	@KafkaListener(groupId = "purchasekafkademo-1",topics = "purchasehistorydemo1",containerFactory = "KafkaListenerContainerFactory")
	public List<Integer> getJsonMessageFromTopic(List<Integer> _list)
	{
		idDetailList = _list;
		//to-do fill data after fetching it from master tables
		return idDetailList;
	}
	
//	@ApiOperation(value = "List of All Ids",
//			consumes = "",
//			produces = "All the keys to be used to call other MicroServices",
//			response = Product.class,
//			tags = "Get All Ids",			
//			notes = "http://localhost:9005/ph/test")	
	@GetMapping("/test")
	public ResponseEntity<List<Integer> > kafkaStreamTest()
	{
		try {
			return new ResponseEntity<List<Integer>>(idDetailList,HttpStatus.CREATED);
		}catch(ResponseStatusException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@ApiOperation(value = "PurchaseHistoryDetail",
			consumes = "",
			produces = "Purchse History Detail",
			response = PurchaseHistory.class,
			tags = "Purchase History Created ",			
			notes = "http://localhost:9005/rvy/api/ph/v1/purchase")
	@GetMapping("/purchase")
	public ResponseEntity<PurchaseHistory> feignCallOrderAndSave()
	{
		try {
			Integer _orderid= idDetailList.get(0);
			Integer _customerid= idDetailList.get(1);
			Integer _storeid = idDetailList.get(2);
			//OrderMaster om = orderClient.getOrderDetail(_id);
			//Object obj = orderClient.getOrderDetail(_id);
			//System.out.println(orderClient.getOrderDetail(_id));
			OrderMaster orderDetailList = orderClient.getOrderDetail(_orderid);
			Customer customerDetail = customerClient.getCustomerById(_customerid);
			Store storeDetail = storeClient.getStorefromId(_storeid);
			String _tmp="";
			int i=0;
			for(Integer id: idDetailList) {
				if(i<3)
				{
					i++;
					continue;
				}
				_tmp+=id.toString();
				if(i==idDetailList.size()-1)
					break;
				_tmp+=",";
				i++;
			}
			List<Product> productList = productClient.getProdDetails(_tmp);
			System.out.println("Printing customer detail");
			System.out.println(customerDetail);
			System.out.println("Printing product details");
			for(Product _prod: productList)
				System.out.println(_prod);
			System.out.println("Store Details");
			System.out.println(storeDetail);
			PurchaseHistory newPurchaseAdded = new PurchaseHistory();
			newPurchaseAdded.setCustomerDetail(customerDetail);
			newPurchaseAdded.setOrderDetail(orderDetailList);
			newPurchaseAdded.setProductDetails(productList);
			newPurchaseAdded.setStoreDetail(storeDetail);
			purchaseHistoryService.addElement(newPurchaseAdded);
			return new ResponseEntity<PurchaseHistory>(newPurchaseAdded,HttpStatus.CREATED);
		}catch(ResponseStatusException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@ApiOperation(value = "PurchaseHistory detail based on id",
			consumes = "Id",
			produces = "PurchaseHistory",
			response = PurchaseHistory.class,
			tags = "Get By Id",			
			notes = "http://localhost:9005/rvy/api/ph/v1/purchase/{id}")
	
	@GetMapping("/purchase/{id}")
	public  ResponseEntity<PurchaseHistory > getAllPurchases(@PathVariable("id") String id){
		try {			
				PurchaseHistory purchaseinfo =
					purchaseHistoryService.getPurchaseHistoryById(id);
			//		log.info(restaurantList.toString());
			return new ResponseEntity<>(purchaseinfo,HttpStatus.OK);
		}catch(Exception e) {
			//		log.error(e.getMessage(),e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@ApiOperation(value = "All PurchaseHistory details",
			consumes = "",
			produces = "List of PurchaseHistory",
			response = PurchaseHistory.class,
			tags = "Get All PurchaseHistory",			
			notes = "http://localhost:9005/ph/rvy/api/ph/v1/purchase/all")
	@GetMapping("/purchase/all")
	public ResponseEntity<List<PurchaseHistory> > getAllPurchseHistory()
	{
		try {
			List<PurchaseHistory> phList = purchaseHistoryService.getAllPurchaseHistory();
			return new ResponseEntity<>(phList,HttpStatus.OK);
		}catch(ResponseStatusException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	@ApiOperation(value = "PurchaseHistory details based on CustomerId",
			consumes = "",
			produces = "PurchaseHistory based on customerId",
			response = PurchaseHistory.class,
			tags = "Get PurchaseHistory based on CustomerId",			
			notes = "http://localhost:9005/ph/rvy/api/ph/v1/purchase/cid/{id}")
	@GetMapping("/purchase/cid/{id}")
	public ResponseEntity<List<PurchaseHistory> > getDetailsFromCustomerId(@PathVariable("id") Integer id){
		try
		{
			List<PurchaseHistory> _phTemp = purchaseHistoryService.findDetailsByCustomerId(id);
			return ResponseEntity.ok(_phTemp);
		}catch(ResponseStatusException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}


}
