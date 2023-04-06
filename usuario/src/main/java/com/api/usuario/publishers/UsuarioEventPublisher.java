package com.api.usuario.publishers;

import com.api.usuario.api.models.publisher.UsuarioModelEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEventPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${apireserva.broker.exchange.userEvent}")
    private String exchangeEventoDeUsuario;

    public void publishEventoDeUsuario(UsuarioModelEvent usuarioModelEvent, String tipoDeAcao){
        usuarioModelEvent.setTipoDeAcao("create");
        rabbitTemplate.convertAndSend(exchangeEventoDeUsuario, "", usuarioModelEvent);
    }

}
