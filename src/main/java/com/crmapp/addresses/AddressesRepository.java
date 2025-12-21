package com.crmapp.addresses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<AddressEntity, Long> {
}
