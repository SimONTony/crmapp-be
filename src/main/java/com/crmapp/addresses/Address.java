package com.crmapp.addresses;

import com.crmapp.Constants;
import com.crmapp.core.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constants.TableName.ADDRESSES)
@Builder
public class Address extends BaseEntity {

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "district", length = 100)
    private String  district;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "building", length = 100)
    private String building;

    @Column(name = "apartment", length = 100)
    private String apartment;

    @Column(name = "postal_code", length = 10)
    private Integer postalCode;


}
