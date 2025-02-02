package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ApiResponse;
import com.app.dto.CategoryDTO;
import com.app.entity.Category;
import com.app.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/public/categories")
	public ResponseEntity<List<Category>> getCategories() {

		List<Category> categoryResponse = categoryService.getAllCategories();

		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}

	@PostMapping
	@Operation(description = "Create New Category")
	public ResponseEntity<?> addCategory(@RequestBody CategoryDTO newCategory) {
		System.out.println("in add category " + newCategory);
		try {
			CategoryDTO createdCategory = categoryService.addNewCategory(newCategory);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/{catId}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in get category " + catId);
		try {
			// invoke service layer method
			return ResponseEntity.ok(categoryService.getCategoryProductDetails(catId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		System.out.println("in update " + categoryId + " " + category);
		return ResponseEntity.ok(categoryService.updateCategoryDetails(categoryId, category));
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long catId) {
		System.out.println("in delete " + catId);
		return ResponseEntity.ok(categoryService.deleteCategoryDetails(catId));
	}

	@GetMapping("/{catId}/products")
	public ResponseEntity<?> getCategoryAndPostDetails(@PathVariable Long catId) {
		System.out.println("in get category n products" + catId);
		try {
			return ResponseEntity.ok(categoryService.getCategoryAndProductDetails(catId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
