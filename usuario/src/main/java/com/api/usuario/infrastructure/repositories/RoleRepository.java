package com.api.usuario.infrastructure.repositories;

import com.api.usuario.infrastructure.entities.Role;
import com.api.usuario.infrastructure.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {


    Optional<Role> findByRoleType(RoleType nome);
}
