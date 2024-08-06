package com.app.dto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoryProductDTO {
	
	private String categoryName;
	private String description;
	 private List<ProductPostRespDTO> products;
	

}
