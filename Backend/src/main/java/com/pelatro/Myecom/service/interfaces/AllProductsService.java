package com.pelatro.Myecom.service.interfaces;

import java.util.List;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.Product;
import com.pelatro.Myecom.model.ProductCategory;
import com.pelatro.Myecom.model.User;

public interface AllProductsService{
    
	MyecomResponse displayAllProducts();
	
	MyecomResponse displayProductsByCategories(String CategoryName);
	
	//StatusResponse save(Product p);

	ProductCategory fetchProductCategoryByCategoryName(String categoryName);
	
	List<Product> fetchProductsByQuery(String query);

	MyecomResponse fetchSearchResults(String query);
    

}
