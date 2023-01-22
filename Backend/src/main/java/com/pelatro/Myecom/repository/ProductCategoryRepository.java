package com.pelatro.Myecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.pelatro.Myecom.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
    
	@Query(value = "from ProductCategory where name = :categoryName")
	ProductCategory findByName(@Param("categoryName") String categoryName);

}
