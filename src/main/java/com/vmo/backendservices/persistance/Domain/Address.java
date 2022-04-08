package com.vmo.backendservices.persistance.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_addresses")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_street1")
    private String street1;

    @Column(name = "address_street2")
    private String street2;

    @Column(name = "address_city")
    private String city;

    @Column(name = "address_state")
    private String state;

    @Column(name = "address_zip")
    private String zip;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;
}
