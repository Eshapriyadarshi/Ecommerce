package com.pelatro.Myecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pelatro.Myecom.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Long>{

	@Query(value = "from Product p where p.category.categoryId = :categoryId")
	List<Product> findByCategory(@Param("categoryId")long categoryId);
	

	
	@Query("from Product p where lower(p.name) like %:pName% or lower(p.category.name) LIKE %:pName% or lower(p.brand) LIKE %:pName% or lower(p.description) LIKE %:pName%")
    List<Product> searchProducts(@Param("pName") String query);
   
}
