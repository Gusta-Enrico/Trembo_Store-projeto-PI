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
@RestController
class TremboStoreController {

    @GetMapping("/nav-links")
    public Map<String, String> getNavLinks() {
        Map<String, String> navLinks = new HashMap<>();
        navLinks.put("Home", "/");
        navLinks.put("Produtos", "/produtos");
        navLinks.put("Sobre Nós", "/sobre");
        navLinks.put("Contato", "/contato");
        return navLinks;
    }

    @GetMapping("/popular-categories")
    public Map<String, String> getPopularCategories() {
        Map<String, String> popularCategories = new HashMap<>();
        popularCategories.put("Proteínas", "/produtos/categoria/proteinas");
        popularCategories.put("Aminoácidos", "/produtos/categoria/aminoacidos");
        popularCategories.put("Vitaminas", "/produtos/categoria/vitaminas");
        return popularCategories;
    }

    @GetMapping("/featured-products")
    public Map<String, String> getFeaturedProducts() {
        Map<String, String> featuredProducts = new HashMap<>();
        featuredProducts.put("Whey Protein 1", "/produtos/1");
        featuredProducts.put("Whey Protein 2", "/produtos/2");
        featuredProducts.put("Whey Protein 3", "/produtos/3");
        featuredProducts.put("Whey Protein 4", "/produtos/4");
        return featuredProducts;
    }
}
