package com.example.demo.infrastructure.delivery.impls;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.domain.produto.useCases.impls.ConsultarProdutosUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.CreateProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.DeleteProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.UpdateProdutoUseCaseImpl;
import com.example.demo.infrastructure.delivery.ProdutoController;
import com.example.demo.infrastructure.delivery.dtos.ProdutoDto;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.exception.ProjectException;

import lombok.RequiredArgsConstructor;

/**
 * ProdutoControllerImpl
 */
@RequestMapping("/produtos")
@RestController
@RequiredArgsConstructor
public class ProdutoControllerImpl implements ProdutoController {
  private final CreateProdutoUseCaseImpl createProdutoUseCaseImpl;
  private final ConsultarProdutosUseCaseImpl consultarProdutosUseCaseImpl;
  private final UpdateProdutoUseCaseImpl updateProdutoUseCaseImpl;
  private final DeleteProdutoUseCaseImpl deleteProdutoUseCaseImpl;

  @Override
  public ProjectResponse<Boolean> criarProduto(ProdutoDto produtoDto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ProjectResponse<Collection<ProdutoDto>> getAllProdutos() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ProjectResponse<Boolean> deletarProdto(Long id) throws ProjectException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ProjectResponse<Boolean> atualizarProduto(ProdutoDto produtoDto, Long Id) {
    // TODO Auto-generated method stub
    return null;
  }

}
