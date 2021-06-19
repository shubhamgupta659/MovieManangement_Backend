package com.vmo.backendservices.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.vmo.backendservices.persistance.Domain.UserRoleInfo;
import com.vmo.backendservices.persistance.Domain.UserRoles;
import com.vmo.backendservices.persistance.Repository.UserRolesRepository;
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

	@Autowired
	UserRolesRepository rolesRepository;
	
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
		UserLoginInfo loginInfo= userRepository.save(userLoginInfo);
		UserRoles roles = new UserRoles();
		roles.setUserId(loginInfo.getUserId());
		roles.setRoleId(1L);
		//rolesRepository.save(roles);
		Set<UserRoleInfo> userRoleInfos = new HashSet<>();
		UserRoleInfo roleInfo = new UserRoleInfo();
		roleInfo.setRoleId(2L);
		roleInfo.setRoleName("USER");
		userRoleInfos.add(roleInfo);
		loginInfo.setRolesInfo(userRoleInfos);
		return loginInfo;

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
