package com.example.demo.core.domain.usuario.useCases.impls;

import java.util.Collection;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.ports.UserRepositoryService;
import com.example.demo.core.domain.usuario.useCases.FindAllUsersUseCase;

import lombok.AllArgsConstructor;

/**
 * FindAllUsuariosUseCaseImpl
 */
@AllArgsConstructor
public class FindAllUsuariosUseCaseImpl implements FindAllUsersUseCase {

  private UserRepositoryService userRepositoryService;

  @Override
  public Collection<Usuario> getAllUsuarios() {
    return this.userRepositoryService.getAllUsers();
  }

}
