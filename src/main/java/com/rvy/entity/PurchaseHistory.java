package com.rvy.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.rvy.model.Customer;
import com.rvy.model.OrderMaster;
import com.rvy.model.Product;
import com.rvy.model.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "purchasehistoryrvy")
//@Data
public class PurchaseHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	private Customer customerDetail;
	private OrderMaster orderDetail;
	private List<Product> productDetails;
	private Store storeDetail;
	
}
