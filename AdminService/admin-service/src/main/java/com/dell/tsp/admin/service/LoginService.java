package com.dell.tsp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	Transction dataDao;
	
	public String getLoginDetails(String userName, String password) {
		String passWord = dataDao.findByUserName(userName);
		String status = "";
		if(passWord.equals(password)) {
			status = "Successful Login!";
		}
		
		if(passWord.equals("User not found")) {
			status = "User Not Found!";
		}
		
		 if(!passWord.equals("User not found") && !passWord.equals(password)){
			status = "Invalid Password! Please try again";
		}
		return status;
	}

}
