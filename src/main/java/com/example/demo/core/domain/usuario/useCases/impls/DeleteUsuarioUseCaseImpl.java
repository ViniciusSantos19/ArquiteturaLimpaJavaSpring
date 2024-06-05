package com.example.demo.core.domain.usuario.useCases.impls;

import com.example.demo.core.domain.usuario.exceptions.UserNotFoundException;
import com.example.demo.core.domain.usuario.ports.UserRepositoryService;
import com.example.demo.core.domain.usuario.useCases.DeleteUsuarioUseCase;

import lombok.AllArgsConstructor;

/**
 * DeleteUsuarioUseCaseImpl
 */
@AllArgsConstructor
public class DeleteUsuarioUseCaseImpl implements DeleteUsuarioUseCase {

  private UserRepositoryService userRepositoryService;

  @Override
  public void delete(Long id) throws UserNotFoundException {
    if (this.userRepositoryService.findUsuarioById(id).isEmpty()) {
      throw new UserNotFoundException();
    }
    this.userRepositoryService.delete(id);
  }
}
