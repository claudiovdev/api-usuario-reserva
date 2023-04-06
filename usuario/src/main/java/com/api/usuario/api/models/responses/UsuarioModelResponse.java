package com.api.usuario.api.models.responses;

import com.api.usuario.infrastructure.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class UsuarioModelResponse {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualização;

}
