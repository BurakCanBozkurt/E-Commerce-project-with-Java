package com.startech.person.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startech.person.model.user.Address;
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
