package com.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
public class BloodStock {
	
	private int bloodStockId;
	private String bloodGroup;
	private int quantity;
	private Date expiryDate;
	private String status;
	
}
