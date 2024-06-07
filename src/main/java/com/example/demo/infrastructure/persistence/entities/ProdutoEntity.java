package com.example.demo.infrastructure.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.demo.core.domain.produto.enums.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProdutoEntity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUTO")
public class ProdutoEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Column(nullable = false)
  private String nome;
  @NotBlank
  @Column(nullable = false)
  private String descricao;
  @NotNull
  @Column(nullable = false)
  private BigDecimal preco;
  @Min(0)
  @Column(nullable = false)
  private int quantidadeEstoque;
  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Categoria categoria;
}
