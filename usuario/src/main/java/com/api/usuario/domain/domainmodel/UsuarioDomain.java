package com.api.usuario.domain.domainmodel;

import com.api.usuario.api.models.publisher.UsuarioModelEvent;
import com.api.usuario.infrastructure.entities.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class UsuarioDomain {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualização;
    private Set<Role> roles = new HashSet<>();

    public UsuarioModelEvent toModelEvent(){
        var usuarioModelEvent = new UsuarioModelEvent();
        usuarioModelEvent.setUsuarioId(this.getId());
        usuarioModelEvent.setEmail(this.getEmail());
        usuarioModelEvent.setNome(this.getNome());
        usuarioModelEvent.setStatus(this.getStatus());
        usuarioModelEvent.setTelefone(this.getTelefone());
        return usuarioModelEvent;
    }

}
