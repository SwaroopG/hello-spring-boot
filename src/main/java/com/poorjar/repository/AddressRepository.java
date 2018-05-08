package com.poorjar.repository;

import com.poorjar.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Collection<Address> findAddressByCity(@Param("city") String name);
}
