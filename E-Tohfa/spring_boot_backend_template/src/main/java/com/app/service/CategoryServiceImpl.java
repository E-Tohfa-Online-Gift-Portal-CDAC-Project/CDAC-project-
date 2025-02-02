package com.app.service;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CategoryDao;
import com.app.dto.ApiResponse;
import com.app.dto.CategoryDTO;
import com.app.dto.CategoryProductDTO;
import com.app.entity.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public CategoryDTO addNewCategory(CategoryDTO categoryDTO) {

		Category category = modelMapper.map(categoryDTO, Category.class);
		Category persistentCategory = categoryDao.save(category);
		return modelMapper.map(persistentCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategoryProductDetails(Long categoryId) {
		Category categoryEnt = categoryDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!!"));
		return modelMapper.map(categoryEnt, CategoryDTO.class);
	}

	@Override
	public ApiResponse updateCategoryDetails(Long categoryId, Category existingCategory) {

		String mesg = "Category Updation Failed : invalid id !!!!";
		if (categoryDao.existsById(categoryId)) {
			categoryDao.save(existingCategory);
			mesg = "Updated category details";
		}
		return new ApiResponse(mesg);
	}

	@Override
	public ApiResponse deleteCategoryDetails(Long categoryId) {

		if (categoryDao.existsById(categoryId)) {
			categoryDao.deleteById(categoryId);
			return new ApiResponse("Delete category details !");
		}
		return new ApiResponse("Category Deletion failed");
	}

	@Override
	public CategoryProductDTO getCategoryAndProductDetails(Long categoryId) {
		Category categoryEnt = categoryDao.getCategoryAndProducts(categoryId) // Optional<Category>
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!!"));
		return modelMapper.map(categoryEnt, CategoryProductDTO.class);
	}

	
	
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}


}
