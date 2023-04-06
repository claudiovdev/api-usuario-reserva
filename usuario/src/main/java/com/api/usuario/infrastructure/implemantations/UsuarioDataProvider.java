package com.api.usuario.infrastructure.implemantations;

import com.api.usuario.domain.domainmodel.UsuarioDomain;
import com.api.usuario.domain.getway.UsuarioGateway;
import com.api.usuario.infrastructure.entities.UsuarioEntity;
import com.api.usuario.infrastructure.mappers.UsuarioMapper;
import com.api.usuario.infrastructure.repositories.UsuarioRepository;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDataProvider implements UsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public UsuarioDomain cadastrar(UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuario);
        usuario = usuarioMapper.toDomain(usuarioRepository.save(usuarioEntity));
        return usuario;
    }

    @Override
    public UsuarioDomain buscarPorId(String usuarioId) {
        UsuarioEntity usuario =  usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException());
        return usuarioMapper.toDomain(usuario);
    }

    @Override
    public List<UsuarioDomain> listarTodos() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();
        return usuarioMapper.toListDomain(usuarioEntities);
    }

}
