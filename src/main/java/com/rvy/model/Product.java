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
public class Product {
	private Integer productId;
	private String category;
	private String type;
	private String brand;
	private String productName;
	private Byte[] image;
	private ProductDesc productDesc;
}
