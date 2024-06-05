package com.example.demo.core.domain.usuario.useCases.impls;

import java.util.Optional;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.exceptions.UserNotFoundException;
import com.example.demo.core.domain.usuario.ports.UserRepositoryService;
import com.example.demo.core.domain.usuario.useCases.FindUsuarioByIdUseCase;

import lombok.AllArgsConstructor;

/**
 * FindUsuarioByIdUseCaseImpl
 */
@AllArgsConstructor
public class FindUsuarioByIdUseCaseImpl implements FindUsuarioByIdUseCase {

  private UserRepositoryService userRepositoryService;

  @Override
  public Optional<Usuario> findById(Long id) throws UserNotFoundException {

    var optionalUsuario = this.userRepositoryService.findUsuarioById(id);

    if (optionalUsuario.isEmpty()) {
      throw new UserNotFoundException();
    }

    return optionalUsuario;
  }

}
