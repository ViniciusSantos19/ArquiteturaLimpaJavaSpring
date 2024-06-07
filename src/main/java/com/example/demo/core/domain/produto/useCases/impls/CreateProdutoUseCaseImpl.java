package com.example.demo.core.domain.produto.useCases.impls;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoAlredyExistsExceptoin;
import com.example.demo.core.domain.produto.ports.ProdutoRepositoryService;
import com.example.demo.core.domain.produto.useCases.CreateProdutoUseCase;

import lombok.AllArgsConstructor;

/**
 * CreateProdutoUseCaesImpl
 */
@AllArgsConstructor
public class CreateProdutoUseCaseImpl implements CreateProdutoUseCase {
  private final ProdutoRepositoryService produtoRepositoryService;

  @Override
  public void create(Produto produto) throws ProdutoAlredyExistsExceptoin {
    if (!this.produtoRepositoryService.findByNome(produto.getNome()).isEmpty()) {
      throw new ProdutoAlredyExistsExceptoin("O produto já existe");
    }
    this.produtoRepositoryService.save(produto);
  }

}
