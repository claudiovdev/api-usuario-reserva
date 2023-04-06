package com.api.usuario.infrastructure.repositories;

import com.api.usuario.infrastructure.entities.Role;
import com.api.usuario.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> ,UsuarioRepositoryQueries, JpaSpecificationExecutor<UsuarioEntity>{

    @EntityGraph(attributePaths = "roles", type = EntityGraph.EntityGraphType.FETCH)
    Optional<UsuarioEntity> findByEmail(String email);
}
