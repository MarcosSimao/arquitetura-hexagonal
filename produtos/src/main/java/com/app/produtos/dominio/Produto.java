package com.app.produtos.dominio;

import com.app.produtos.dominio.dtos.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Produto {

    private UUID codigo;
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    public Produto(ProdutoDto dto){
        this.sku=dto.getSku();
        this.nome= dto.getNome();
        this.preco=dto.getPreco();
        this.quantidade=dto.getQuantidade();
    }

    public void atualizarEstoque(Double quantidade){
        this.quantidade=quantidade;
    }

    public ProdutoDto toProdutoDto(){
        return new ProdutoDto(this.sku,this.nome,this.preco,this.quantidade);
    }
}
