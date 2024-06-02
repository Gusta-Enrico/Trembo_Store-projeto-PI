package br.com.trembostore.trembostore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trembostore.trembostore.Model.Produtos;
import br.com.trembostore.trembostore.repository.RepositorioProduto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public List<Produtos> listarProdutos() {
        return repositorioProduto.findAll();
    }


}
