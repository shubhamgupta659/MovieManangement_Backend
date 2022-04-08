package com.vmo.backendservices.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PasswordGroupDTO {

    private String password;
    private String confirmPassword;
}
