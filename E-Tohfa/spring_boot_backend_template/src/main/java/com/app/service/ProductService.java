package com.app.service;
import com.app.dto.ProductPostReqDTO;
import com.app.dto.ProductResponse;
import com.app.entity.Product;

public interface ProductService {

	//ApiResponse postNewProduct(ProductPostReqDTO requestDTO);
	
	//ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

	ProductPostReqDTO addProduct(Long categoryId, Product product);
	String deleteProduct(Long productId);
}
