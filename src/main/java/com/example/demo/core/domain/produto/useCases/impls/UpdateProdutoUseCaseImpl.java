package com.example.demo.core.domain.produto.useCases.impls;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;
import com.example.demo.core.domain.produto.ports.ProdutoRepositoryService;
import com.example.demo.core.domain.produto.useCases.UpdateProdutoUseCAse;

import lombok.AllArgsConstructor;

/**
 * CreateProdutoUseCaesImpl
 */
@AllArgsConstructor
public class UpdateProdutoUseCaseImpl implements UpdateProdutoUseCAse {
  private final ProdutoRepositoryService produtoRepositoryService;

  @Override
  public void update(Produto produto, Long id) throws ProdutoNotFoundException {
    if (this.produtoRepositoryService.findById(id).isEmpty()) {
      throw new ProdutoNotFoundException();
    }

    this.produtoRepositoryService.save(produto);
  }
}
