package com.rvy.model;

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
public class OrderDetail {

	private Integer orderDetailId;
	private Integer quantity;
	private Double sellingPrice;
	private Double discount;
	private Double sellingPriceAfterDiscount;
	private Double itemTotal;
	private Integer inventoryId;
	
}