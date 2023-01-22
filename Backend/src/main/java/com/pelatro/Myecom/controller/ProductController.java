package com.pelatro.Myecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.MyecomResponseWrapper;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.Product;
import com.pelatro.Myecom.service.interfaces.AllProductsService;


@RestController
@RequestMapping(value="/Home")
@CrossOrigin(origins ="http://localhost:4200")
public class ProductController {
	
	MyecomResponseWrapper myecomwrapper = new MyecomResponseWrapper();
	
   	@Autowired
	private AllProductsService productService;
   	
//   	@Autowired
//   	private SubCategoryService subcategoryService;

	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public ResponseEntity<MyecomResponse> showAllProducts() {
		
		MyecomResponse response = productService.displayAllProducts();
		return new ResponseEntity<MyecomResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public ResponseEntity<MyecomResponse> showProductsByCategory(@PathVariable("id") String categoryName) {
		
		MyecomResponse response = productService.displayProductsByCategories(categoryName);
		return new ResponseEntity<MyecomResponse>(response, HttpStatus.OK);
	}
	

//	@RequestMapping(value = "/addProducts", method = RequestMethod.POST, consumes = "application/json")
//	public ResponseEntity<MyecomResponse> addProducts(@RequestBody Product p) {
//	    System.out.println(	p.getCategory());
//		StatusResponse response = productService.save(p);
//		MyecomResponse myecomresponse = myecomwrapper.createResponse(response.getStatus(), response);
//		return new ResponseEntity<MyecomResponse>(myecomresponse, HttpStatus.OK);
//		
//	}

}
