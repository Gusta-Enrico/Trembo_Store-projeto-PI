package br.com.trembostore.trembostore.controller;

import br.com.trembostore.trembostore.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trembostore.trembostore.Model.Produtos;
import br.com.trembostore.trembostore.repository.RepositorioProduto;
import br.com.trembostore.trembostore.service.ProdutoService;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class CadastroProdutoController {

    @Autowired
    private ProdutoService produtoService;

    private RepositorioProduto repositorioProduto;

    @GetMapping("/produto/cadastroProduto")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("produto", new Produtos());
        return "cadastroProduto";
    }

    @PostMapping("/produto/cadastroProduto")
    public ModelAndView salvarProduto(@ModelAttribute("dados") Produtos dadosRecebidos,RedirectAttributes redirAttr) {

        ModelAndView mv = new ModelAndView("redirect:/produto/cadastrarProduto.html");

        redirAttr.addFlashAttribute("dados", dadosRecebidos);
        System.out.println("cadastrado com sucesso" + dadosRecebidos.getId());

       produtoService.salvarProduto(dadosRecebidos);

        return mv;


    }

    public void setProdutoService(ProdutoService service){
        this.produtoService = service;
    }

    @GetMapping({"", "/"})
    public String listaProdutos (Model model){
        List<Produtos> produtos = repositorioProduto.findAll();
        model.addAttribute("produtos", produtos);
        return "listaProdutos.html";
    }
}
