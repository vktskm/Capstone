package com.example.sicilia.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sicilia.security.entity.ERole;
import com.example.sicilia.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
