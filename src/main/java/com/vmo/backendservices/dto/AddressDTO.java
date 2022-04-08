package com.vmo.backendservices.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddressDTO {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
}
