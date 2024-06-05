package com.example.demo.core.domain.usuario.useCases;

import java.util.Collection;

import com.example.demo.core.domain.usuario.Usuario;

public interface FindAllUsersUseCase {
  public Collection<Usuario> getAllUsuarios();
}
