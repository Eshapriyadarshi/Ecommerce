package com.pelatro.Myecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pelatro.Myecom.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@Query(value = "from Cart c where c.product.productId = :productId and c.user.userId = :userId")
	Cart findByProductIdAndUserId(@Param("productId") long productId, @Param("userId") long userId);
	
	@Query(value = "from Cart c where c.user.userId = :userId")
	List<Cart> findByUserId(@Param("userId") long userId);

}
