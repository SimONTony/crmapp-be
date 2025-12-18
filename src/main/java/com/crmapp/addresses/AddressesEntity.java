package com.crmapp.addresses;

import com.crmapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")


//    @Id
//    @GeneratedValue
//    @Column(name = "contract_id")
//    private Long contractId;
//
//    @Column(name = "person_id")
//    private String personId;
//


public class AddressesEntity extends UserEntity {
    @Column(name = "addresses_id")
    private Integer addresId;

    @Column(name = "country")
    private String country;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String  district;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "appartment")
    private String appartment;

    @Column(name = "postCode")
    private Integer postalCode;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "address_id",);

}
