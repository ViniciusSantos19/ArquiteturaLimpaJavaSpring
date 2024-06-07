package com.example.demo.core.domain.produto.useCases.impls;

import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;
import com.example.demo.core.domain.produto.ports.ProdutoRepositoryService;
import com.example.demo.core.domain.produto.useCases.DeleteProdutoUseCase;

import lombok.AllArgsConstructor;

/**
 * DeleteProdutoUseCaseImpl
 */
@AllArgsConstructor
public class DeleteProdutoUseCaseImpl implements DeleteProdutoUseCase {

  private final ProdutoRepositoryService produtoRepositoryService;

  @Override
  public void delete(Long id) throws ProdutoNotFoundException {
    if (produtoRepositoryService.findById(id).isEmpty()) {
      throw new ProdutoNotFoundException("produto não  foi achado");
    }
    produtoRepositoryService.delete(id);
  }

}
