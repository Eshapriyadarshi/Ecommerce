package com.pelatro.Myecom.service.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.Cart;
import com.pelatro.Myecom.model.Order;



public interface CartService {
	
	StatusResponse removeProductsfromCart(long cartId);

	StatusResponse addProductsToCart(Cart cart);
	
	MyecomResponse displayCart(long UserId);

	StatusResponse placeOrder(Order order) throws JsonProcessingException;
	
	MyecomResponse displayOrder(long OrderId) throws JsonProcessingException;

	StatusResponse placeOrderHTTP(Order order) throws JsonProcessingException, MalformedURLException, ProtocolException, IOException;;

}
