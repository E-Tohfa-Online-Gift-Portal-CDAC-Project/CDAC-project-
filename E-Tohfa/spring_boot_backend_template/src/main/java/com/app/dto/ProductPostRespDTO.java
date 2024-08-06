package com.app.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostRespDTO{
	
	private Long productId;
	private String productName;	
	private String image;
	private String description;	
	private Integer quantity;
	private double price;
	private double discount;
	private double specialPrice;
}
