package com.app.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

	@Query("select c from Category c left join fetch c.products where c.id=:id")
	Optional<Category> getCategoryAndProducts(Long id);
	

	Category findByCategoryName(String categoryName);


}
