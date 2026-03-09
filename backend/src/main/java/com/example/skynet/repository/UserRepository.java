package com.example.skynet.repository;
import com.example.skynet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find transporters for the Admin role
    java.util.List<User> findByRole(String role);
}