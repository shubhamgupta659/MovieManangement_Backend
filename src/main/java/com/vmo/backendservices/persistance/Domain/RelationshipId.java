package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RelationshipId implements Serializable {
    private Long userId;
    private Long roleId;
}