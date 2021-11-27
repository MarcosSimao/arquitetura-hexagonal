package com.app.produtos.dominio.adaptadores.service;

import com.app.produtos.dominio.Produto;
import com.app.produtos.dominio.dtos.EstoqueDto;
import com.app.produtos.dominio.dtos.ProdutoDto;
import com.app.produtos.dominio.portas.interfaces.ProdutoServicePort;
import com.app.produtos.dominio.portas.repositories.ProdutoRespositoryPort;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoServicePort {

    private final ProdutoRespositoryPort produtoRespositoryPort;
    private Produto produto;

    @Override
    public List<ProdutoDto> buscarProdutos() {
        List<Produto> produtos = this.produtoRespositoryPort.buscarTodos();
        List<ProdutoDto> produtoDtos = produtos.stream().map(Produto::toProdutoDto).collect(Collectors.toList());
        return produtoDtos;
    }

    @Override
    public void criarProduto(ProdutoDto produtoDto) {
        Produto produto = new Produto(produtoDto);
        this.produtoRespositoryPort.salvar(produto);
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDto estoque) throws NotFoundException {
        Produto produto = this.produtoRespositoryPort.buscarPeloSku(sku);
        if (Objects.isNull(produto)) {
            throw new NotFoundException("produto não encontrado");
        }
        produto.atualizarEstoque(estoque.getQuantidade());
        this.produtoRespositoryPort.salvar(produto);

    }

}
