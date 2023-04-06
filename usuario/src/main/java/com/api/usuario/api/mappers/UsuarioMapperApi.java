package com.api.usuario.api.mappers;

import com.api.usuario.api.models.requests.UsuarioModelRequest;
import com.api.usuario.api.models.responses.UsuarioModelResponse;
import com.api.usuario.domain.domainmodel.UsuarioDomain;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UsuarioMapperApi {

    @Autowired
    private ModelMapper mapper;

    public UsuarioModelResponse toResponse(UsuarioDomain usuarioDomain){
        UsuarioModelResponse usuarioModelResponse = mapper.map(usuarioDomain, UsuarioModelResponse.class);
        return usuarioModelResponse;
    }

    public UsuarioDomain toDomain(UsuarioModelRequest usuarioModelRequest){
        UsuarioDomain usuarioDomain = mapper.map(usuarioModelRequest, UsuarioDomain.class);
        usuarioDomain.setId(UUID.randomUUID().toString());
        usuarioDomain.setDataCadastro(LocalDateTime.now());
        usuarioDomain.setDataAtualização(LocalDateTime.now());
        return usuarioDomain;
    }

    public List<UsuarioModelResponse> listaToResponse(List<UsuarioDomain> usuariosDomain){
       return usuariosDomain.stream().map(usuarioDomain -> toResponse(usuarioDomain)).collect(Collectors.toList());
    }
}
