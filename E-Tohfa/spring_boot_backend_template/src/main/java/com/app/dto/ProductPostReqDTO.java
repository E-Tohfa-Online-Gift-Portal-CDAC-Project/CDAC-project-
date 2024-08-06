package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductPostReqDTO {

	private Long categoryId;
	private String productName;
	private String image;
	private String description;
	private Integer quantity;
	private double price;
	private double discount;
	private double specialPrice;
	private Long sellerId;

}
