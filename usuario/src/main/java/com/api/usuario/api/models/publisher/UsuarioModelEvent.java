package com.api.usuario.api.models.publisher;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class UsuarioModelEvent {

    private String usuarioId;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private String tipoDeAcao;
}
