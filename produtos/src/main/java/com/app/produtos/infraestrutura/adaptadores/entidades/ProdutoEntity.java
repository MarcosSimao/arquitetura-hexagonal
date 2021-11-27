package com.app.produtos.infraestrutura.adaptadores.entidades;

import com.app.produtos.dominio.Produto;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
public class ProdutoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    public ProdutoEntity(Produto produto){
        this.sku= produto.getSku();
        this.nome= produto.getNome();
        this.preco= produto.getPreco();
        this.quantidade=produto.getQuantidade();
    }
    public void atualizar(Produto produto){
        this.sku= produto.getSku();
        this.nome= produto.getNome();
        this.preco= produto.getPreco();
        this.quantidade=produto.getQuantidade();
    }
    public Produto toProduto(){
        return new Produto(this.codigo,this.sku,this.nome,this.preco,this.quantidade);
    }

}
