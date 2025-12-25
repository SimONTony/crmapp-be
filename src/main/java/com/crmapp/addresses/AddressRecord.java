package com.crmapp.addresses;

public record AddressRecord(
        String country,
        String state,
        String city,
        String district
) {
}
