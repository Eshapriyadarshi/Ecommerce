//package com.pelatro.Myecom.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.pelatro.Myecom.model.ProductSubcategory;
//
//public interface SubCategoryRepository extends JpaRepository<ProductSubcategory, Long>{
//	
//	@Query(value = "from ProductSubcategory ps where ps.category = :categoryId")
//	List<ProductSubcategory> findByCategory(@Param("categoryId") long categoryId);
//
//}
