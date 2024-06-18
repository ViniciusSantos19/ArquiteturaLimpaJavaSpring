package com.example.demo.infrastructure.persistence.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.exceptions.UserNotFoundException;
import com.example.demo.core.domain.usuario.exceptions.UsuarioAlredyExistException;
import com.example.demo.core.domain.usuario.ports.UserRepositoryService;
import com.example.demo.infrastructure.persistence.converters.UsuarioRepositoryConverter;
import com.example.demo.infrastructure.persistence.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioServiceImpl implements UserRepositoryService {

  private final UsuarioRepository repository;

  private final UsuarioRepositoryConverter converter;

  @Override
  public void delete(Long id) throws UserNotFoundException {
    this.repository.deleteById(id);
  }

  @Override
  public void save(Usuario usuario) throws UsuarioAlredyExistException {
    this.repository.save(this.converter.mapToTable(usuario));
  }

  @Override
  public Collection<Usuario> getAllUsers() {
    return this.repository.findAll().stream().map(usuario -> converter.mapToEntity(usuario))
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Usuario> findUsuarioById(long id) throws UserNotFoundException {
    var optionalUsuario = this.repository.findById(id);
    if (optionalUsuario.isEmpty()) {
      throw new UserNotFoundException();
    }
    var userEntity = optionalUsuario.get();
    return Optional.of(this.converter.mapToEntity(userEntity));
  }

  @Override
  public Boolean doesUsuarioExistByName(String nome) {
    return !this.repository.findByNome(nome).isEmpty();
  }
}
