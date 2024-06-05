package com.example.demo.infrastructure.delivery;

import java.util.Collection;

import com.example.demo.infrastructure.delivery.dtos.UsuarioDto;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.exception.ProjectException;

public interface UsuarioController {

  public ProjectResponse<Collection<UsuarioDto>> getAllUsuarios() throws ProjectException;

  public ProjectResponse<Boolean> criarUsuario(UsuarioDto usuairo) throws ProjectException;
}
