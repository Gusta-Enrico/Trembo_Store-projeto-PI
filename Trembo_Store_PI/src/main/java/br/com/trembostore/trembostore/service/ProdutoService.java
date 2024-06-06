package br.com.trembostore.trembostore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.trembostore.trembostore.Model.Produto;
import br.com.trembostore.trembostore.repository.RepositorioProduto;
import java.util.List;



@Service
public class ProdutoService {
    
    @Autowired
    private RepositorioProduto repositorioProduto;

    
    public ProdutoService(RepositorioProduto repositorioProduto) {

        this.repositorioProduto = repositorioProduto;
    }

    public void salvarProduto(Produto produtos) {
        this.repositorioProduto.save(produtos);
    }

    public List<Produto> listarProdutos() {
        return repositorioProduto.findAll();
    }

    public Produto atualizarProduto(Produto produto) {
        return repositorioProduto.save(produto);
    }

    public Produto buscarProdutoPorId(long id) {
        return repositorioProduto.findById(id).orElse(null);
    }

    public void deletarProduto(long id) {
        repositorioProduto.deleteById(id);
    }


    public void attStatus(Long id, String newStatus) {
        Produto produto = repositorioProduto.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado o produto"));
        produto.setStatus(newStatus);
        repositorioProduto.save(produto);

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }


}
