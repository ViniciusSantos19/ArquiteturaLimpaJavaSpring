package com.example.demo.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.core.domain.produto.useCases.impls.ConsultarProdutosUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.CreateProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.DeleteProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.UpdateProdutoUseCaseImpl;
import com.example.demo.infrastructure.persistence.converters.ProdutoRepositoryConverter;
import com.example.demo.infrastructure.persistence.impl.ProdutoRepositoryServiceImpl;
import com.example.demo.infrastructure.persistence.repositories.ProdutoRepository;

/**
 * ProdutoConfig
 */
@Configuration
public class ProdutoConfig {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Bean
  public ProdutoRepositoryConverter createProdutoRepositoryConverter() {
    return new ProdutoRepositoryConverter();
  }

  @Bean
  public ProdutoRepositoryServiceImpl createProdutoRepostityServiceImpl() {
    return new ProdutoRepositoryServiceImpl(produtoRepository, createProdutoRepositoryConverter());
  }

  @Bean
  public ConsultarProdutosUseCaseImpl createConsultarProdutosUseCaseImpl() {
    return new ConsultarProdutosUseCaseImpl(createProdutoRepostityServiceImpl());
  }

  @Bean
  public CreateProdutoUseCaseImpl nameCreateProdutoUseCaseImpl() {
    return new CreateProdutoUseCaseImpl(createProdutoRepostityServiceImpl());
  }

  @Bean
  public DeleteProdutoUseCaseImpl nameDeleteProdutoUseCaseImpl() {
    return new DeleteProdutoUseCaseImpl(createProdutoRepostityServiceImpl());
  }

  @Bean
  public UpdateProdutoUseCaseImpl nameUpdateProdutoUseCaseImpl() {
    return new UpdateProdutoUseCaseImpl(createProdutoRepostityServiceImpl());
  }
}
