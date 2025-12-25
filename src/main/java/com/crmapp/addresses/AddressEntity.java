package com.crmapp.addresses;

import com.crmapp.core.model.BaseEntity;
import com.crmapp.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@Builder
public class AddressEntity extends BaseEntity {

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

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "postCode")
    private Integer postalCode;


}
