package com.pelatro.Myecom.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.Product;
import com.pelatro.Myecom.model.ProductCategory;
import com.pelatro.Myecom.model.User;
import com.pelatro.Myecom.repository.ProductCategoryRepository;
import com.pelatro.Myecom.repository.ProductsRepository;
import com.pelatro.Myecom.service.interfaces.AllProductsService;

@Service
public class ProductsServiceImplementation implements AllProductsService{

	@Autowired
	private ProductsRepository productRepo ;

	@Autowired 
	private ProductCategoryRepository categoryRepo;


	@Override
	public MyecomResponse displayAllProducts() {
		MyecomResponse response = new MyecomResponse();
		try {
			List<Product> products= productRepo.findAll();
			if(products.isEmpty()) {
				response.setStatus("No products in the database");
				response.setContent(null);
				System.out.println("----- database empty-----");
			}
			else {
				response.setStatus("OK");
				response.setContent(products);
				System.out.println("----- sending products list------");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}
		return response;
	}


//	@Override
//	public StatusResponse save(Product p) {
//		StatusResponse response = new StatusResponse();
//		try {
//
//			productRepo.save(p);
//			response.setStatus("OK");
//			System.out.println("----- Product saved successfully------");
//
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			response.setStatus("FAILURE");
//		}
//		return response;
//
//	}


	@Override
	public MyecomResponse displayProductsByCategories(String categoryName) {
		MyecomResponse response = new MyecomResponse();
		System.out.println(categoryName);
        
		try { 
			ProductCategory p=fetchProductCategoryByCategoryName(categoryName.toLowerCase());
			System.out.println(p);
			long categoryId;
			List<Product> products;
			if(p!=null) {
			   categoryId=p.getCategoryId();
			   System.out.println(categoryId);
			   products=productRepo.findByCategory((long)categoryId);
			
			   if(products.isEmpty()) {
				   response.setStatus("No products in the category");
				   response.setContent(null); 
				   System.out.println("-----no subcategory-----"); 
			   }
			   else { 
				   response.setStatus("OK"); 
				   response.setContent(products);
	      		   System.out.println("----- sending products list------"); 
	      		}

			}
			
		} 
		catch (Exception e) {
			e.printStackTrace(); 
			response.setStatus("FAILURE");
		}
		
		return response; 
		    
}

	@Override
	public ProductCategory fetchProductCategoryByCategoryName(String categoryName) {
        
		  return categoryRepo.findByName(categoryName);
	}


	@Override
	public List<Product> fetchProductsByQuery(String query) {
		return productRepo.searchProducts(query);
           
	}


	@Override
	public MyecomResponse fetchSearchResults(String query) { 
        MyecomResponse response = new MyecomResponse();
        
		try { 
			
			List<Product> p=fetchProductsByQuery(query.toLowerCase());

			if(p.isEmpty()) {
				response.setStatus("No search result");
				p=productRepo.findAll();
				response.setContent(p); 
				System.out.println("-----no products relevant to search-----"); 
			 }
			 else { 
				response.setStatus("OK"); 
				response.setContent(p);
	      		System.out.println("----- sending search result------"); 
	         }
			
		} 
		catch (Exception e) {
			e.printStackTrace(); 
			response.setStatus("FAILURE");
		}
		
		return response; 
	}

}
