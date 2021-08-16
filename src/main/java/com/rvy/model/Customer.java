package com.rvy.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;

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
public class Customer {
	
	
	private Integer customerId;
	private Integer uin;
	private String name;
	private String email;
	@Length(max = 10)
	private Long mobile;
	private LocalDate birthdate;	
	private String doorNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private Long zipCode;
	private Integer regionId;
}
