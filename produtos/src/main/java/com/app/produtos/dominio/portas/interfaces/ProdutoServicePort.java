package com.app.produtos.dominio.portas.interfaces;

import com.app.produtos.dominio.dtos.EstoqueDto;
import com.app.produtos.dominio.dtos.ProdutoDto;
import javassist.NotFoundException;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDto> buscarProdutos();

    void criarProduto(ProdutoDto produtoDto);

    void atualizarEstoque(String sku, EstoqueDto estoque) throws NotFoundException;
}
