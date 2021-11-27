package com.app.produtos.infraestrutura.adaptadores.repositories;

import com.app.produtos.dominio.Produto;
import com.app.produtos.dominio.portas.repositories.ProdutoRespositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoRepository implements ProdutoRespositoryPort {

   private SpringProdutoRepository springProdutoRepository;

    @Override
    public List<Produto> buscarTodos() {
        return null;
    }

    @Override
    public Produto buscarPeloSku(String sku) {
        return null;
    }

    @Override
    public void salvar(Produto produto) {

    }
}
