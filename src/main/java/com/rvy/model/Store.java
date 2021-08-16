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
public class Store {
	private Integer storeId;

	private String name;

    private String address;

    private Long mobileNumber; 
    private String email;
    
    
}
