package com.startech.person.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startech.person.model.user.User;
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

}
