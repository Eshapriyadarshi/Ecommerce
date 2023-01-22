package com.pelatro.Myecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.User;
import com.pelatro.Myecom.repository.LoginRepository;
import com.pelatro.Myecom.service.interfaces.UserLoginService;

@Service
public class LoginService implements UserLoginService{
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Override
	public MyecomResponse login(User user) {
		MyecomResponse response = new MyecomResponse();
		try {
			String userEmailId = user.getEmailId();
			String userPassword = user.getPassword();
			
			//user having the emailId and password entered
			User tempUser=fetchUserByEmailIdAndPassword(userEmailId,userPassword);
			
			//if the user is in the DB with that password
			if(tempUser!=null) {
				
				response.setStatus("OK");
				response.setContent(tempUser);
				System.out.println("-----User logged In-----");
			}
			else {
				response.setStatus("Invalid emailid or password");
				response.setContent(null);
				System.out.println("----- Invalid Credentials------");
            }    				
	    } 
		catch (Exception e) {
			e.printStackTrace();
			response.setStatus("FAILURE");
		}
		return response;
	}

	@Override
	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return loginRepo.findbyEmailIdAndPassword(emailId, password);
	}
	

}
