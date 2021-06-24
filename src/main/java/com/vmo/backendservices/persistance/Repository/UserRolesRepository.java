package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.UserRoleKey;
import com.vmo.backendservices.persistance.Domain.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, UserRoleKey> {
}
