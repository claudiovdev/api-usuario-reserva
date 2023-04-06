package com.api.usuario.api.models.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UsuarioModelRequest {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
}
