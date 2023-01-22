package com.pelatro.Myecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.MyecomResponseWrapper;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.User;
import com.pelatro.Myecom.service.interfaces.UserLoginService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {

   MyecomResponseWrapper myecomwrapper = new MyecomResponseWrapper();
	
	@Autowired
	private UserLoginService userloginService;

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MyecomResponse> saveUser(@RequestBody User user) {
		
		MyecomResponse response = userloginService.login(user);
		return new ResponseEntity<MyecomResponse>(response, HttpStatus.OK);
	}
}
