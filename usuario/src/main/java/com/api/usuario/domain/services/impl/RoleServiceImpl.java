package com.api.usuario.domain.services.impl;

import com.api.usuario.domain.getway.RoleGateway;
import com.api.usuario.domain.services.RoleService;
import com.api.usuario.infrastructure.entities.Role;
import com.api.usuario.infrastructure.enums.RoleType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    RoleGateway roleGateway;

}
