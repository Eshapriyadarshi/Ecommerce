package com.pelatro.Myecom.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import com.pelatro.Myecom.model.Cart;
import com.pelatro.Myecom.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;

import com.pelatro.Myecom.repository.CartRepository;
import com.pelatro.Myecom.service.interfaces.CartService;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;

	@Override
	public StatusResponse addProductsToCart(Cart cart) {
		StatusResponse response = new StatusResponse();
		Cart c= cartRepo.findByProductIdAndUserId(cart.getProduct().getProductId(), cart.getUser().getUserId());
		try {
			if (c != null) {
				Cart c2 = cartRepo.getOne(c.getId());
				c2.setQuantity(c2.getQuantity() + 1);
				cartRepo.save(c2);
				response.setStatus("OK");
				System.out.println("-----product already exist-----");

			} else {
				cartRepo.save(cart);
				response.setStatus("OK");
				System.out.println("-----product doesn't exist adding new row----");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}
		return response;
	}

	@Override
	public StatusResponse removeProductsfromCart(long cartId) {
		StatusResponse response = new StatusResponse();
		//Optional<Cart> c= cartRepo.findById(cartId);
		try {
			cartRepo.deleteById(cartId);
			response.setStatus("OK");
			System.out.println("-----product removed-----"); 
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}
		return response;
	}

	@Override
	public MyecomResponse displayCart(long userId) {
		
	MyecomResponse response = new MyecomResponse();
	 List<Cart> carts=cartRepo.findByUserId(userId);
		try {
			if(carts.isEmpty()) {
				response.setContent(null);
				response.setStatus("Empty cart");
				System.out.println("Nothing in cart");
			}
			else {
				response.setContent(carts);
				response.setStatus("OK");
				System.out.println("Sending cart list");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}
		return response;	
    }

	@Override
	public StatusResponse placeOrder(Order order) throws JsonProcessingException {

		StatusResponse response = new StatusResponse();
		
		System.out.println("Order received");
		long orderId=order.getOrderId();

		ObjectMapper obj = new ObjectMapper();
		String orderAsString = obj.writeValueAsString(order);
		String orderIdAsString = obj.writeValueAsString(orderId);
		System.out.println(orderAsString);
		
		
		String ip="localhost";
		
		try (Socket clientSocket = new Socket(ip, 4999)) {
			OutputStreamWriter os=new OutputStreamWriter(clientSocket.getOutputStream());
			PrintWriter out = new PrintWriter(os);
			out.println(orderAsString);
			out.flush();
			out.println(orderIdAsString);
			out.flush();
			System.out.println("data sent to server");
			
						
			response.setStatus("OK");
			System.out.println("OrderDetails Written in Hbase");
		}
		 catch (UnknownHostException e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		} catch (IOException e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}
		return response;
	}

	@Override
	public MyecomResponse displayOrder(long orderId) throws JsonProcessingException{
		MyecomResponse response = new MyecomResponse();
		String orderdetails=null;
	
		ObjectMapper obj = new ObjectMapper();
		String orderIdAsString = obj.writeValueAsString(orderId);
		
		String ip="localhost";
		
		try (Socket clientSocket = new Socket(ip, 4990)) {
			OutputStreamWriter os=new OutputStreamWriter(clientSocket.getOutputStream());
			PrintWriter out = new PrintWriter(os);
			out.println(orderIdAsString);
			out.flush();
			System.out.println("data sent to server");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			if((orderdetails=in.readLine())!=null) {
				System.out.println(orderdetails);
			}
		    Order order= obj.readValue(orderdetails, Order.class);

			response.setContent(order);
			response.setStatus("OK");
			System.out.println("OrderDetails Written in Hbase");
		}
		 catch (UnknownHostException e) {
			e.printStackTrace();
			response.setContent(null);
			response.setStatus("FAILURE");
		} catch (IOException e) {
			e.printStackTrace();
			response.setContent(null);
			response.setStatus("FAILURE");
		}
		
		return response;
	}

	@Override
	public StatusResponse placeOrderHTTP(Order order) throws JsonProcessingException, MalformedURLException, ProtocolException, IOException {

		StatusResponse response = new StatusResponse();		String POST_URL = "https://localhost/Cart/placeOrderHTTP";
		ObjectMapper obj = new ObjectMapper();
		byte[] orderAsByte= obj.writeValueAsString(order).getBytes("UTF-8");

		URL url = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setConnectTimeout(10000);
		con.setReadTimeout(10000);

		//con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);


		OutputStream os = con.getOutputStream();
		//os.write(POST_PARAMS.getBytes());
		try (DataOutputStream writer = new DataOutputStream(os)) {
			writer.write(orderAsByte);

			os.flush();
			os.close();
			// For POST only - END

			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code :: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { 
				//success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response1 = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response1.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response1.toString());
			} else {
				System.out.println("POST request not worked");
			}


		}
		finally {
			con.disconnect();
		}
		return response;
	}
	
}
      

