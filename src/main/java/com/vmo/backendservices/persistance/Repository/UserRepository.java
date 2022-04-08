package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{
	UserInfo findByUserName(String username);
}
