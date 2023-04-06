package com.api.usuario.api.controlleries;

import com.api.usuario.api.clients.UsuarioClient;
import com.api.usuario.api.models.responses.ReservaModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioReservaController {

    @Autowired
    UsuarioClient usuarioClient;

    @GetMapping("/usuarios/{usuarioId}/reservas")
    public List<ReservaModelResponse> listarTodasReservasPorUsuarioId(@PathVariable(value = "usuarioId") String usuarioId){

        return usuarioClient.listarTodasReservasPorUsuarioId(usuarioId);
    }
}
