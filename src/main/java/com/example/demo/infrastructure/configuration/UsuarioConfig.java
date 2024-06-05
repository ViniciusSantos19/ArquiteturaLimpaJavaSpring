package com.example.demo.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.core.domain.usuario.useCases.impls.CriarUsuarioUseCaseImpl;
import com.example.demo.core.domain.usuario.useCases.impls.DeleteUsuarioUseCaseImpl;
import com.example.demo.core.domain.usuario.useCases.impls.FindAllUsuariosUseCaseImpl;
import com.example.demo.core.domain.usuario.useCases.impls.FindUsuarioByIdUseCaseImpl;
import com.example.demo.infrastructure.delivery.converters.UsuarioRestConverter;
import com.example.demo.infrastructure.persistence.converters.UsuarioRepositoryConverter;
import com.example.demo.infrastructure.persistence.impl.UsuarioServiceImpl;
import com.example.demo.infrastructure.persistence.repositories.UsuarioRepository;

/**
 * UsuarioConfig
 */
@Configuration
public class UsuarioConfig {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Bean
  public UsuarioRepositoryConverter createUsuarioRepositoryConverter() {
    return new UsuarioRepositoryConverter();
  }

  @Bean
  public UsuarioRestConverter createUsuarioRestConverter() {
    return new UsuarioRestConverter();
  }

  @Bean
  public UsuarioServiceImpl createUsuarioServiceImpl() {
    return new UsuarioServiceImpl(usuarioRepository, createUsuarioRepositoryConverter());
  }

  @Bean
  public FindAllUsuariosUseCaseImpl createFindAllUsuarioUseCaseImpl() {
    return new FindAllUsuariosUseCaseImpl(createUsuarioServiceImpl());
  }

  @Bean
  public CriarUsuarioUseCaseImpl createCriarUsuarioUseCaseImpl() {
    return new CriarUsuarioUseCaseImpl(createUsuarioServiceImpl());
  }

  @Bean
  public DeleteUsuarioUseCaseImpl createDeleteUsuairoUseCaseImpl() {
    return new DeleteUsuarioUseCaseImpl(createUsuarioServiceImpl());
  }

  @Bean
  public FindUsuarioByIdUseCaseImpl createFindUsuarioByIdImpl() {
    return new FindUsuarioByIdUseCaseImpl(createUsuarioServiceImpl());
  }
}
