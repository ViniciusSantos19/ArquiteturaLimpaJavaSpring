package com.example.demo.infrastructure.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infrastructure.persistence.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
  public Optional<UsuarioEntity> findById(Long id);

  public Optional<UsuarioEntity> findByNome(String nome);
}
