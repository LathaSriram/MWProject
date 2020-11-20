package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	
	
	//@PostMapping(path="/login", produces = "application/json")
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		User userobj= null;
		String tmpEmailId=user.getEmailId();
		String tmpPassword=user.getPassword();
		 if(tmpEmailId!=null && tmpPassword!=null) {
		 userobj=service.fetchUserByEmailIdAndPassword(tmpEmailId, tmpPassword); }
		 if(userobj==null) { 
	     throw new Exception("Either Username or password is incorrect"); }
		 return userobj;
		
	}
}
