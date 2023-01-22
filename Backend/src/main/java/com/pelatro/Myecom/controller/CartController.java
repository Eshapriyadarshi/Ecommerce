package com.pelatro.Myecom.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

//package com.pelatro.Myecom.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.MyecomResponseWrapper;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.Cart;
import com.pelatro.Myecom.model.Order;
import com.pelatro.Myecom.service.interfaces.CartService;

@RestController
@RequestMapping(value="/Cart")
//@CrossOrigin(origins ="http://localhost:4200")
public class CartController {
	
    MyecomResponseWrapper myecomwrapper = new MyecomResponseWrapper();
	
   	@Autowired
	private CartService cartService;

	
	@RequestMapping(value = "/addCart", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MyecomResponse> addToCart(@RequestBody Cart cart) {
		StatusResponse response = cartService.addProductsToCart(cart);
		MyecomResponse myecomresponse = myecomwrapper.createResponse(response.getStatus(), response);
		return new ResponseEntity<MyecomResponse>(myecomresponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ResponseEntity<MyecomResponse> removeFromCart(@PathVariable("id") String cartId) {
		StatusResponse response = cartService.removeProductsfromCart(Long.parseLong(cartId));
		MyecomResponse myecomresponse = myecomwrapper.createResponse(response.getStatus(), response);
		return new ResponseEntity<MyecomResponse>(myecomresponse, HttpStatus.OK);
	
   }
	
	@RequestMapping(value = "/showCart/{id}", method = RequestMethod.GET)
	public ResponseEntity<MyecomResponse> showCart(@PathVariable("id") String userId) {
		MyecomResponse response = cartService.displayCart(Long.parseLong(userId));
		
		return new ResponseEntity<MyecomResponse>(response, HttpStatus.OK);
	
   }
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MyecomResponse> placeOrder(@RequestBody Order order) throws JsonProcessingException {
		StatusResponse response = cartService.placeOrder(order);
		MyecomResponse myecomresponse = myecomwrapper.createResponse(response.getStatus(), response);
		return new ResponseEntity<MyecomResponse>(myecomresponse, HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/getOrderDetails/{id}", method = RequestMethod.GET)
	public ResponseEntity<MyecomResponse> getOrder(@PathVariable("id") String orderId) throws JsonProcessingException{
		MyecomResponse response = cartService.displayOrder(Long.parseLong(orderId));
		return new ResponseEntity<MyecomResponse>(response, HttpStatus.OK);
	
   }
	
	@RequestMapping(value = "/placeOrderHTTP", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MyecomResponse> placeOrderHTTP(@RequestBody Order order) throws MalformedURLException, ProtocolException, IOException {
		StatusResponse response = cartService.placeOrderHTTP(order);
		MyecomResponse myecomresponse = myecomwrapper.createResponse(response.getStatus(), response);
		return new ResponseEntity<MyecomResponse>(myecomresponse, HttpStatus.OK);
	
	}
	
}
