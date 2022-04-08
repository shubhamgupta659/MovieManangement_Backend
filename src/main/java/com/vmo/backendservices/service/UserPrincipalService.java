package com.vmo.backendservices.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.vmo.backendservices.persistance.Domain.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipalService implements UserDetails{

	private UserInfo userLoginDetails;
	
	public UserPrincipalService(UserInfo userLoginDetails) {
		super();
		this.userLoginDetails = userLoginDetails;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userLoginDetails.getRolesInfo().stream()
		.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
		.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userLoginDetails.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userLoginDetails.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
