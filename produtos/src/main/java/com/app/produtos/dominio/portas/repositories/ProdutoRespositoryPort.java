package com.app.produtos.dominio.portas.repositories;

import com.app.produtos.dominio.Produto;

import java.util.List;

public interface ProdutoRespositoryPort {

    List<Produto> buscarTodos();
    Produto buscarPeloSku(String sku);
    void salvar(Produto produto);
}
