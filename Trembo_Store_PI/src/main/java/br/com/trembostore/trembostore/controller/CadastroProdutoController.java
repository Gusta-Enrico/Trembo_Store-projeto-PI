package br.com.trembostore.trembostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.trembostore.trembostore.Model.Produtos;
import br.com.trembostore.trembostore.service.produtoService;

@Controller
@RequestMapping("/produto")
public class CadastroProdutoController {
    
    private produtoService produtoService;


    @PostMapping("/cadastro")
    public void salvarUsuario(@RequestBody Produtos produtos) {
        produtoService.salvarProduto(produtos);
    }
}
