package com.example.demo.infrastructure.delivery;

import java.util.Collection;

import com.example.demo.infrastructure.delivery.dtos.ProdutoDto;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.exception.ProjectException;

/**
 * ProdutoController
 */
public interface ProdutoController {
  public ProjectResponse<Boolean> criarProduto(ProdutoDto produtoDto);

  public ProjectResponse<Boolean> deletarProdto(Long id) throws ProjectException;

  public ProjectResponse<Collection<ProdutoDto>> getAllProdutos();

  public ProjectResponse<Boolean> atualizarProduto(ProdutoDto produtoDto, Long id) throws ProjectException;
}
