package com.app.produtos.aplicacacao.adaptadores.controller;

import com.app.produtos.dominio.dtos.EstoqueDto;
import com.app.produtos.dominio.dtos.ProdutoDto;
import com.app.produtos.dominio.portas.interfaces.ProdutoServicePort;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
public class ProdutoController {
   private final ProdutoServicePort produtoServicePort;

    @GetMapping
    public List<ProdutoDto> buscarProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PostMapping
    public void criarProduto(@RequestBody ProdutoDto produtoDto) {
       produtoServicePort.criarProduto(produtoDto);
    }

    @PutMapping("/{sku}")
    public void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDto estoque) throws NotFoundException {
      produtoServicePort.atualizarEstoque(sku,estoque);
    }
}
