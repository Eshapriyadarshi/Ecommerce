package com.pelatro.Myecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pelatro.Myecom.commonresponse.*;
import com.pelatro.Myecom.model.User;
import com.pelatro.Myecom.service.interfaces.UserSignupService;



@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins ="http://localhost:4200")
public class SignupController {
    
	MyecomResponseWrapper myecomwrapper = new MyecomResponseWrapper();
	
	@Autowired
	private UserSignupService userService;

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MyecomResponse> saveUser(@RequestBody User user) {
		
		StatusResponse response = userService.save(user);
		MyecomResponse myecomresponse = myecomwrapper.createResponse(response.getStatus(), response);
		return new ResponseEntity<MyecomResponse>(myecomresponse, HttpStatus.OK);
	}
	
}
