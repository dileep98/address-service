package com.dk.addressservice.repo;

import com.dk.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("select a from Address a where a.employeeId = :employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
