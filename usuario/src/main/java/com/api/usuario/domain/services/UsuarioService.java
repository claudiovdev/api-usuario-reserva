package com.api.usuario.domain.services;

import com.api.usuario.domain.domainmodel.UsuarioDomain;

import java.util.List;

public interface UsuarioService {

    public UsuarioDomain cadastrar(UsuarioDomain usuarioDomain);

    UsuarioDomain buscarPorId(String usuarioId);

    List<UsuarioDomain> listarTodos();
    UsuarioDomain cadastrarUsuario(UsuarioDomain usuarioDomain);


}
