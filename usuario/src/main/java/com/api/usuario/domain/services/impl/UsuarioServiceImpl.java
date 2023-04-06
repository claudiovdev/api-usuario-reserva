package com.api.usuario.domain.services.impl;

import com.api.usuario.api.models.publisher.UsuarioModelEvent;
import com.api.usuario.domain.domainmodel.UsuarioDomain;
import com.api.usuario.domain.getway.RoleGateway;
import com.api.usuario.domain.getway.UsuarioGateway;
import com.api.usuario.domain.services.UsuarioService;

import com.api.usuario.infrastructure.entities.Role;
import com.api.usuario.infrastructure.enums.RoleType;
import com.api.usuario.infrastructure.repositories.RoleRepository;
import com.api.usuario.publishers.UsuarioEventPublisher;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioGateway usuarioGateway;

    @Autowired
    RoleRepository repository;

    @Autowired
    UsuarioEventPublisher usuarioEventPublisher;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UsuarioDomain cadastrar(UsuarioDomain usuarioDomain) {
        return usuarioGateway.cadastrar(usuarioDomain);
    }

    @Override
    public UsuarioDomain buscarPorId(String usuarioId) {
        return usuarioGateway.buscarPorId(usuarioId);
    }

    @Override
    public List<UsuarioDomain> listarTodos() {
        return usuarioGateway.listarTodos();
    }


    @Override
    public UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain){
        Role role = repository.findByRoleType(RoleType.ROLE_USUARIO).orElseThrow(() -> new RuntimeException("Erro: Role não existe"));
        usuarioDomain.setSenha(passwordEncoder.encode(usuarioDomain.getSenha()));
        usuarioDomain.getRoles().add(role);
        usuarioDomain = cadastrar(usuarioDomain);
        usuarioEventPublisher.publishEventoDeUsuario(usuarioDomain.toModelEvent(), "create");
        return usuarioDomain;
    }
}
