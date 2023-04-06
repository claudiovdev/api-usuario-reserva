package com.api.usuario.domain.getway;

import com.api.usuario.domain.domainmodel.UsuarioDomain;

import java.util.List;

public interface UsuarioGateway {


    UsuarioDomain cadastrar(UsuarioDomain usuario);

    UsuarioDomain buscarPorId(String usuarioId);

    List<UsuarioDomain> listarTodos();

}
