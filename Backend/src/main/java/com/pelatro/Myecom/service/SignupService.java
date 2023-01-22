package com.pelatro.Myecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.User;
import com.pelatro.Myecom.repository.SignupRepository;
import com.pelatro.Myecom.service.interfaces.UserSignupService;



@Service
public class SignupService implements UserSignupService{

	@Autowired
	private SignupRepository signupRepo;

	@Override
	public StatusResponse save(User user) {
		StatusResponse response = new StatusResponse();
		try {
			String userEmailId = user.getEmailId();
			if(userEmailId!=null && !"".equals(userEmailId)) {
				User tempUser=fetchUserByEmailId(userEmailId);
				if(tempUser!=null) {
					response.setStatus("User Already Exists");
				    System.out.println("----- User Exists------");
				}
				else {
					signupRepo.save(user);
					response.setStatus("OK");
					System.out.println("----- User saved successfully------");
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
	public User fetchUserByEmailId(String emailId) {
		  return signupRepo.findbyEmailId(emailId);
	}

}
