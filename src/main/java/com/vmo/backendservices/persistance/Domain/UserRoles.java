package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_roles")
public class UserRoles {

    @EmbeddedId
    UserRoleKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_Id")
    UserInfo userInfo;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    RoleInfo roleInfo;
}
