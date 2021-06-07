package com.vmo.backendservices.service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;

public class UserPrincipalService implements UserDetails{

	private UserLoginInfo userLoginDeatils;
	
	public UserPrincipalService(UserLoginInfo userLoginDeatils) {
		super();
		this.userLoginDeatils = userLoginDeatils;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userLoginDeatils.getRolesInfo().stream()
		.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
		.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userLoginDeatils.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userLoginDeatils.getUsername();
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
