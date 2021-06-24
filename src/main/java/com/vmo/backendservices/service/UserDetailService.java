package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {

    UserDetails loadUserByUsername(String username);

    List<UserInfo> findAll();

    UserInfo save(UserInfo userInfo);

    Optional<UserInfo> findOne(Long id);

    void delete(Long id);


}
