package com.vmo.backendservices.persistance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vmo.backendservices.persistance.Domain.UserRoleInfo;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleInfo, Integer>{

}
