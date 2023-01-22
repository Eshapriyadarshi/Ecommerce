package com.pelatro.Myecom.commonresponse;

public class MyecomResponseWrapper {

	public MyecomResponse createResponse( String status, Object content) {
		MyecomResponse myecom = new MyecomResponse();
		myecom.setStatus(status);
		myecom.setContent(content);
		return myecom;
	}
}
