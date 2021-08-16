package com.rvy.model;

import java.time.LocalDate;

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
public class ProductInventory {
	private Integer inventoryId;
	private Double buyingPrice;
	private Double minimumSellingPrice;
	private String batchcode;
	private LocalDate batchdate;
	private Integer quantity;
	private Integer reorderLevel;
	private String status;
	private Integer storeId;
	private Product product;
}
