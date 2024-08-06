package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	
	private String streetNo;
	private String buildingName;
	private String locality;
	private String city;
	private String state;
	private String pincode;
}
