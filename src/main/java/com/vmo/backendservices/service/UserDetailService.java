package com.vmo.backendservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;

public interface UserDetailService {
	
	UserDetails loadUserByUsername(String username);
	
	List<UserLoginInfo> findAll();
	
	UserLoginInfo save(UserLoginInfo userLoginInfo);
	
	Optional<UserLoginInfo> findOne(Integer id);
	
	void delete(Integer id);
	
	

}
