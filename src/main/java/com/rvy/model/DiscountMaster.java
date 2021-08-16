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
public class DiscountMaster {

	private Integer discountMasterId;
	private String discountCode;
	private String eligibilityCriteria;
}
