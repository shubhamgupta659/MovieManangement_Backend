package com.vmo.backendservices.persistance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmo.backendservices.persistance.Domain.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{
	UserInfo findByUsername(String username);
}
