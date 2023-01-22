package com.pelatro.Myecom.service.interfaces;

import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.User;

public interface UserSignupService {
	
	StatusResponse save(User user);
	
	User fetchUserByEmailId(String emailId);

}
