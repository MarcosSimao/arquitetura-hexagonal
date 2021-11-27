package com.app.produtos.infraestrutura.adaptadores.repositories;

import com.app.produtos.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
 Optional<ProdutoEntity> findBySku(String sku);
}
