package com.pelatro.Myecom.service.interfaces;

import com.pelatro.Myecom.commonresponse.MyecomResponse;
import com.pelatro.Myecom.commonresponse.StatusResponse;
import com.pelatro.Myecom.model.User;

public interface UserLoginService {
	
    MyecomResponse login(User user);
	
	User fetchUserByEmailIdAndPassword(String emailId, String password);
}
