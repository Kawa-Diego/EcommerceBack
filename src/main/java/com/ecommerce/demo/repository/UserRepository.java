package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.ecommerce.demo.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}