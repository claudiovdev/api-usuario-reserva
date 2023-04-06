package com.api.usuario.api.clients;

import com.api.usuario.api.models.responses.ReservaModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UsuarioClient {

    @Autowired
    RestTemplate restTemplate;

    @Value("${apireserva.api.url.reserva}")
    String REQUEST_URL_RESERVA;

    //String REQUEST_URI = "http://localhost:8082";

    public List<ReservaModelResponse> listarTodasReservasPorUsuarioId(String usuarioId){
        List<ReservaModelResponse> resultadoDaBusca = null;
        String url = REQUEST_URL_RESERVA + "/reservas?usuarioId=" + usuarioId;

        try{
            var resultado = restTemplate.exchange(url, HttpMethod.GET, null, ReservaModelResponse[].class);
            resultadoDaBusca = Arrays.asList(resultado.getBody());
        }catch (HttpStatusCodeException e){
            e.getMessage();
        }
        return resultadoDaBusca;
    }
}
