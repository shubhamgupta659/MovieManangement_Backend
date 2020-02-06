package com.vmo.backendservices.persistance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;

@Repository
public interface UserRepository extends JpaRepository<UserLoginInfo, Integer>{
	UserLoginInfo findByUsername(String username);
}
