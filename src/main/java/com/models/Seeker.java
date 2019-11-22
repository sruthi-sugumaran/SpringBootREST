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
public class Seeker {
	
	private int seekerId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String bloodGroup;
	private String city;
	private long phone;

	@JsonCreator
	public Seeker(
			@JsonProperty("seekerId") int seekerId, 
			@JsonProperty("firstName") String firstName, 
			@JsonProperty("lastName") String lastName, 
			@JsonProperty("age") int age, 
			@JsonProperty("gender") String gender, 
			@JsonProperty("bloodGroup") String bloodGroup, 
			@JsonProperty("city") String city,
			@JsonProperty("phone") long phone) {
		super();
		this.seekerId = seekerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.city = city;
		this.phone = phone;
	}
}
