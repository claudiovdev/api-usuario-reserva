package com.api.usuario.api.models.requests;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtRequest {

    @NonNull
    private String token;
    private String type = "Bearer";
}
