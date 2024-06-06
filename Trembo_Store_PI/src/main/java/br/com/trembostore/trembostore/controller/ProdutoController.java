package br.com.trembostore.trembostore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trembostore.trembostore.Model.Produto;
import br.com.trembostore.trembostore.service.ProdutoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    private static final String DIRETORIO_UPLOAD = "C:\\Users\\gusta\\Desktop\\teste pi\\Trembo_Store-projeto-PI\\Trembo_Store_PI\\src\\main\\resources\\static\\img";


    @GetMapping("new")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastroProduto";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutosPorId(@PathVariable("id") Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> salvarProduto(@ModelAttribute Produto produto, @RequestParam("files") MultipartFile[] files, @RequestParam("imagem") String imagem) {
        try {
            List<String> listaImagens = uploadImagens(files);
            produto.setListaImagens(listaImagens);
            produto.setImagem(imagem);
            produto.setStatus("Ativo");
            produtoService.salvarProduto(produto);

            return ResponseEntity.status(HttpStatus.FOUND).location(ServletUriComponentsBuilder.fromPath("/listaProdutos.html").build().toUri()).build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Adição de produto com falha");
        }
    }
    

    public void setProdutoService(ProdutoService service){
        this.produtoService = service;
    }

    public ResponseEntity<List<Produto>> listaProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Produto>> todosProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping({"", "/"})
    public String listaProdutos(Model model){
        List<Produto> produtos = produtoService.listarProdutos();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    private List<String> uploadImagens(MultipartFile[] files) throws IOException {
        List<String> listaImagens = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String Nomefile = file.getOriginalFilename(); //nome original do arquivo
                String filePath = DIRETORIO_UPLOAD + "\\" + Nomefile;
                Files.write(Paths.get(filePath), file.getBytes());
                listaImagens.add(Nomefile);
            }
        }
        return listaImagens;
    }


    @GetMapping("/carrosel-produtos")
    public String carroselDeProdutos() {
        return "redirect:/static/carrosel.html";
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> attProduto (@PathVariable("id") Long id, @ModelAttribute Produto produto, @RequestParam(value = "files", required = false) MultipartFile[] files, @RequestParam("imagem") String imagem) {
        try {
            Produto existeProduto = produtoService.buscarProdutoPorId(id);
            if (existeProduto == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este produto não foi encontrado");
            }

            existeProduto.setNome(produto.getNome());
            existeProduto.setAvaliacao(produto.getAvaliacao());
            existeProduto.setDescricao(produto.getDescricao());
            existeProduto.setPreco(produto.getPreco());
            existeProduto.setQtdProduto(produto.getQtdProduto());
            existeProduto.setImagem(produto.getImagem());

            if (files != null && files.length > 0) {
                List<String> imagens = uploadImagens(files);
                existeProduto.setListaImagens(imagens);
            }

            produtoService.atualizarProduto(existeProduto);
            return ResponseEntity.ok().body("Produto cadastrado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o produto");
        }
    }
}
