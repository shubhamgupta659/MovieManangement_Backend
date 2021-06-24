package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "role_info")
public class RoleInfo {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    /*@ManyToMany()
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserInfo> userInfo;*/

}
