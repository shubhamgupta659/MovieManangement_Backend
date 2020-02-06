package com.vmo.backendservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;
import com.vmo.backendservices.service.UserDetailService;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public UserLoginInfo create(@RequestBody UserLoginInfo userLoginInfo){
	    return userDetailService.save(userLoginInfo);
	}

}
