package com.rvy.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;



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
public class OrderMaster {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer billNo;
	private LocalDate orderDate;
	private Double orderAmount;
	private Double taxAmount;
	//private DiscountMaster discountMaster;
	private Double billingAmount;
	private String paymentMode;
	private String currencyType;
	private Integer customerId;

	private Integer storeId;
	private List<OrderDetail> orderDetailList;
}
