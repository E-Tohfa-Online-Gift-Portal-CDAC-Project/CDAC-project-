package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ProductPostReqDTO;
import com.app.entity.Product;
import com.app.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	
	
	@PostMapping("/admin/categories/{categoryId}/product")
	public ResponseEntity<ProductPostReqDTO> addProduct(@Valid @RequestBody Product product, @PathVariable Long categoryId) {

		ProductPostReqDTO savedProduct = productservice.addProduct(categoryId, product);

		return new ResponseEntity<ProductPostReqDTO>(savedProduct, HttpStatus.CREATED);
	}

//	@PostMapping
//	public ResponseEntity<?> addProductPost(@RequestBody ProductPostReqDTO dto) {
//		System.out.println("in add product " + dto);
//		try {
//			return ResponseEntity.status(HttpStatus.CREATED).body(productservice.postNewProduct(dto));
//		} catch (RuntimeException e) {
//			System.out.println(e);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
//
//		}
//	}
	
	

}
