package com.api.usuario.infrastructure.mappers;

import com.api.usuario.domain.domainmodel.UsuarioDomain;
import com.api.usuario.infrastructure.entities.UsuarioEntity;
import com.api.usuario.infrastructure.enums.StatusUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    @Autowired
    private ModelMapper mapper;

    public UsuarioEntity toEntity(UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = mapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setStatus(StatusUsuario.ATIVO);
        return usuarioEntity;
    }

    public UsuarioDomain toDomain(UsuarioEntity usuarioEntity) {
        usuarioEntity.getDataAtualização();
        usuarioEntity.getDataCadastro();
        return mapper.map(usuarioEntity, UsuarioDomain.class);

    }


    public List<UsuarioDomain> toListDomain(List<UsuarioEntity> usuarioEntities) {
        return usuarioEntities.stream().map(usuarioEntity -> toDomain(usuarioEntity)).collect(Collectors.toList());
    }
}
