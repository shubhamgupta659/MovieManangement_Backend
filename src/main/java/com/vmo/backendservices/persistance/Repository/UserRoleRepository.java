package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.UserRoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleInfo, Long> {

}
