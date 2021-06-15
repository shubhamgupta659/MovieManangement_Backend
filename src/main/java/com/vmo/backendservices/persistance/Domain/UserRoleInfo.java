package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "register_user_role")
public class UserRoleInfo {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

}
