package com.api.usuario.config.security;

import com.api.usuario.domain.domainmodel.UsuarioDomain;
import com.api.usuario.infrastructure.entities.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private UUID userId;
    private String nome;
    private String email;
    @JsonIgnore
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(UsuarioEntity userDomain){
        List<GrantedAuthority> authorities = userDomain.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                UUID.fromString(userDomain.getUsuarioId()),
                userDomain.getNome(),
                userDomain.getEmail(),
                userDomain.getSenha(),
                authorities);
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
