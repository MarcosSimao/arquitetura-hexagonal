package com.app.produtos.infraestrutura.adaptadores.repositories;

import com.app.produtos.dominio.Produto;
import com.app.produtos.dominio.portas.repositories.ProdutoRespositoryPort;
import com.app.produtos.infraestrutura.adaptadores.entidades.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoRepository implements ProdutoRespositoryPort {

   private SpringProdutoRepository springProdutoRepository;

    @Override
    public List<Produto> buscarTodos() {
        List<ProdutoEntity> produtoEntities= springProdutoRepository.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public Produto buscarPeloSku(String sku) {
        Optional<ProdutoEntity> produtoEntity= springProdutoRepository.findBySku(sku);
        if(produtoEntity.isPresent())
        {
            return produtoEntity.get().toProduto();
        }
      throw  new IllegalStateException("Produto não encontrado");
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity;
        if(Objects.isNull(produto.getCodigo())){
            produtoEntity= new ProdutoEntity(produto);
        }else{
           produtoEntity =springProdutoRepository.findById(produto.getCodigo()).get();
           produtoEntity.atualizar(produto);
        }
        springProdutoRepository.save(produtoEntity);
    }
}
