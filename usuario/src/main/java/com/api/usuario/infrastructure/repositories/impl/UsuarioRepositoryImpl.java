package com.api.usuario.infrastructure.repositories.impl;

import com.api.usuario.infrastructure.entities.UsuarioEntity;
import com.api.usuario.infrastructure.repositories.UsuarioRepository;
import com.api.usuario.infrastructure.repositories.UsuarioRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryQueries {

    @Autowired @ Lazy
    UsuarioRepository usuarioRepository;
}
