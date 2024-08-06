package com.app.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
	
	Page<Product> findByProductNameLike(String keyword, Pageable pageDetails);

}
