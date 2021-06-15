package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {

    UserDetails loadUserByUsername(String username);

    List<UserLoginInfo> findAll();

    UserLoginInfo save(UserLoginInfo userLoginInfo);

    Optional<UserLoginInfo> findOne(Long id);

    void delete(Long id);


}
