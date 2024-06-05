package com.example.demo.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infrastructure.persistence.entities.ProdutoEntity;

/**
 * ProdutoRepository
 */
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
