package com.app.service;

import java.util.List;
import com.app.dto.ApiResponse;
import com.app.dto.CategoryDTO;
import com.app.dto.CategoryProductDTO;
import com.app.entity.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	CategoryDTO getCategoryProductDetails(Long categoryId);

	ApiResponse updateCategoryDetails(Long categoryId, Category existingCategory);

	ApiResponse deleteCategoryDetails(Long categoryId);

	CategoryProductDTO getCategoryAndProductDetails(Long categoryId);

	CategoryDTO addNewCategory(CategoryDTO categoryDTO);

}
