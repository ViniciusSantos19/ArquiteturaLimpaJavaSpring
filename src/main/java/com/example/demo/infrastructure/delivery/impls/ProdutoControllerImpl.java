package com.example.demo.infrastructure.delivery.impls;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.domain.produto.exceptions.ProdutoAlredyExistsExceptoin;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;
import com.example.demo.core.domain.produto.useCases.impls.ConsultarProdutosUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.CreateProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.DeleteProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.UpdateProdutoUseCaseImpl;
import com.example.demo.infrastructure.delivery.ProdutoController;
import com.example.demo.infrastructure.delivery.converters.ProdutoRestConverter;
import com.example.demo.infrastructure.delivery.dtos.ProdutoDto;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.constants.CommonConstants;
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
  private final ProdutoRestConverter produtoRestConverter;

  @Override
  public ProjectResponse<Boolean> criarProduto(ProdutoDto produtoDto) {
    try {
      this.createProdutoUseCaseImpl.create(this.produtoRestConverter.mapToEntity(produtoDto));
    } catch (ProdutoAlredyExistsExceptoin e) {
      return new ProjectResponse<>(
          CommonConstants.FAILURE,
          String.valueOf(HttpStatus.CONFLICT.value()),
          "Product already exists");
    }

    return new ProjectResponse<>(
        HttpStatus.CREATED.toString(),
        String.valueOf(HttpStatus.CREATED.value()),
        CommonConstants.OK,
        true);
  }

  @Override
  public ProjectResponse<Collection<ProdutoDto>> getAllProdutos() {
    Collection<ProdutoDto> produtos = consultarProdutosUseCaseImpl.getAllProdutos().stream()
        .map(produtoRestConverter::mapRoRest).collect(Collectors.toList());
    return new ProjectResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()), CommonConstants.OK,
        produtos);
  }

  @Override
  public ProjectResponse<Boolean> deletarProdto(Long id) throws ProjectException {
    try {
      deleteProdutoUseCaseImpl.delete(id);
    } catch (ProdutoNotFoundException e) {
      return new ProjectResponse<>(HttpStatus.NOT_FOUND.toString(), String.valueOf(HttpStatus.NOT_FOUND.value()),
          CommonConstants.FAILURE, false);
    }
    return new ProjectResponse<>(HttpStatus.NO_CONTENT.toString(), String.valueOf(HttpStatus.NO_CONTENT.value()),
        CommonConstants.OK, true);
  }

  @Override
  public ProjectResponse<Boolean> atualizarProduto(ProdutoDto produtoDto, Long id) throws ProjectException {
    try {
      updateProdutoUseCaseImpl.update(produtoRestConverter.mapToEntity(produtoDto), id);
    } catch (ProdutoNotFoundException e) {
      return new ProjectResponse<>(HttpStatus.NOT_FOUND.toString(), String.valueOf(HttpStatus.NOT_FOUND.value()),
          CommonConstants.FAILURE, false);

    }
    return new ProjectResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()), CommonConstants.OK,
        true);
  }

}
