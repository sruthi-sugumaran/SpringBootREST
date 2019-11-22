package com.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString
public class BloodBank {
	
	public int bloodBankId;
	public String bloodBankName;
	public String address;
	public String city;
	public long phone;
	public String website;
	public String email;

	@JsonCreator
	public BloodBank(
			@JsonProperty("bloodBankId") int bloodBankId, 
			@JsonProperty("bloodBankName")String bloodBankName, 
			@JsonProperty("address")String address, 
			@JsonProperty("city")String city, 
			@JsonProperty("phone")long phone, 
			@JsonProperty("website")String website,
			@JsonProperty("email")String email) {
		super();
		this.bloodBankId = bloodBankId;
		this.bloodBankName = bloodBankName;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}	
}
