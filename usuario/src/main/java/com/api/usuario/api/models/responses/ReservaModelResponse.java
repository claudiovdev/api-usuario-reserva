package com.api.usuario.api.models.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservaModelResponse {
    private String id;
    private String titulo;
    private String descricao;
    private String status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataInicialDaReserva;
    private LocalDateTime dataFinalDaReserva;
    private LocalDateTime dataAtualização;
}
