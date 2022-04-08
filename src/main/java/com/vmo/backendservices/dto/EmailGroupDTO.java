package com.vmo.backendservices.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString
public class EmailGroupDTO {

    private String email;

    private String confirmEmail;
}