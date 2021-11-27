package com.app.produtos.dominio.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;
}
