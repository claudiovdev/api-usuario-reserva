package com.api.usuario.api.controlleries;

import com.api.usuario.api.mappers.UsuarioMapperApi;
import com.api.usuario.api.models.requests.JwtRequest;
import com.api.usuario.api.models.requests.LoginRequest;
import com.api.usuario.api.models.requests.UsuarioModelRequest;
import com.api.usuario.api.models.responses.UsuarioModelResponse;


import com.api.usuario.config.security.JwtProvider;
import com.api.usuario.domain.domainmodel.UsuarioDomain;
import com.api.usuario.domain.services.RoleService;
import com.api.usuario.domain.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class UsuarioController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
   private UsuarioService usuarioService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtProvider jwtProvider;





    @Autowired
    private UsuarioMapperApi mapperApi;

    @PostMapping("usuarios")
    public UsuarioModelResponse cadastrarUsuario(@RequestBody UsuarioModelRequest usuarioModelRequest){

        UsuarioDomain usuario = mapperApi.toDomain(usuarioModelRequest);
       usuario =  usuarioService.cadastrarUsuario(usuario);
        UsuarioModelResponse usuarioModelResponse =  mapperApi.toResponse(usuario);
        return usuarioModelResponse;
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModelResponse buscarUsuario(@PathVariable("usuarioId") String usuarioId){
        UsuarioDomain usuarioDomain = usuarioService.buscarPorId(usuarioId);
        UsuarioModelResponse usuarioModelResponse = mapperApi.toResponse(usuarioDomain);
        return usuarioModelResponse;
    }

    @PostMapping("login")
    public ResponseEntity<JwtRequest> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwt(authentication);
        return ResponseEntity.ok(new JwtRequest(jwt));
    }

    @GetMapping
    public List<UsuarioModelResponse> listarTodos(){
        List<UsuarioModelResponse> usuarios = mapperApi.listaToResponse(usuarioService.listarTodos());
        return usuarios;
    }
}
