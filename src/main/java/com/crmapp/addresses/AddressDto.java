package com.crmapp.addresses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    private Long addressId;
    private String country;
    private String state;
    private String district;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private Integer postalCode;


}
