package com.vmo.backendservices.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserDTO {

    private String firstName;

    private String lastName;

    private EmailGroupDTO emailGroup;

    private String userName;

    private String phone;

    private String notification;

    private PasswordGroupDTO passwordGroup;

    private boolean sendCatalog;

    private List<AddressDTO> addresses = null;

}
