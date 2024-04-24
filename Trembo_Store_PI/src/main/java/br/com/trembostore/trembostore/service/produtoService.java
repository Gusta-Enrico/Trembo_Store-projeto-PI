package br.com.trembostore.trembostore.service;

import org.springframework.stereotype.Service;

import br.com.trembostore.trembostore.Model.Produtos;
import br.com.trembostore.trembostore.repository.RepositorioProduto;

@Service
public class produtoService {
    
    private RepositorioProduto repositorioProduto;

    public void salvarProduto(Produtos produtos) {
        this.repositorioProduto.save(produtos);
    }
}
