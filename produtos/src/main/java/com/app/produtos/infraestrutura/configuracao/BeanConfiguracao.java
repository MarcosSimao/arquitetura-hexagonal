package com.app.produtos.infraestrutura.configuracao;

import com.app.produtos.dominio.adaptadores.service.ProdutoServiceImpl;
import com.app.produtos.dominio.portas.interfaces.ProdutoServicePort;
import com.app.produtos.dominio.portas.repositories.ProdutoRespositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProdutoServicePort produtoservice(ProdutoRespositoryPort produtoRespositoryPort){
        return new ProdutoServiceImpl(produtoRespositoryPort);
    }
}
