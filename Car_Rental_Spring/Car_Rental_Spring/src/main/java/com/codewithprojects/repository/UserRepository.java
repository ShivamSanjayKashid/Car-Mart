package com.codewithprojects.repository;

import com.codewithprojects.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // Method to find user by email

    boolean existsByEmail(String email);

}
