package com.vmo.backendservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;
import com.vmo.backendservices.persistance.Repository.UserRepository;

@Transactional
@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService,UserDetailService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLoginInfo userLoginInfo = userRepository.findByUsername(username);
		if(userLoginInfo==null) {
			throw new UsernameNotFoundException("User Not Followed");
		}
		return new UserPrincipalService(userLoginInfo);
	}

	@Override
	public List<UserLoginInfo> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public UserLoginInfo save(UserLoginInfo userLoginInfo) {
		return userRepository.save(userLoginInfo);
	}

	@Override
	public Optional<UserLoginInfo> findOne(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);	
	}
	
	
	

}
