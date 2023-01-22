package com.pelatro.Myecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.service.interfaces.AllProductsService;


@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping(value="/Search")
public class SearchBarController {
	
	@Autowired 
	AllProductsService productsService;
	
	@RequestMapping(value = "/pro/{query}", method = RequestMethod.GET)
	public ResponseEntity<MyecomResponse> searchResults(@PathVariable String query){
		  System.out.println(query);
		  MyecomResponse  response= productsService.fetchSearchResults(query);
		  return new ResponseEntity<MyecomResponse>(response, HttpStatus.OK);	
          
	}
	
	
	
}
