package br.com.trembostore.trembostore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trembostore.trembostore.Model.Produtos;
import br.com.trembostore.trembostore.repository.RepositorioProduto;


@Service
public class ProdutoService {
    
    private RepositorioProduto repositorioProduto;

    @Autowired
       public ProdutoService(RepositorioProduto repositorioProduto) {
       this.repositorioProduto = repositorioProduto;
    }



    public void salvarProduto(Produtos produtos) {
        this.repositorioProduto.save(produtos);
    }


}
