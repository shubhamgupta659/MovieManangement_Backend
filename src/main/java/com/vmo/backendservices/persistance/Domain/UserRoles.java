package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(RelationshipId.class)
@Table(name = "users_roles")
public class UserRoles {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "role_id")
    private Long roleId;
}
