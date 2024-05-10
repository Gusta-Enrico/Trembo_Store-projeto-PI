package br.com.trembostore.trembostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.trembostore.trembostore.Model.Produtos;
import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.repository.RepositorioProduto;
import br.com.trembostore.trembostore.repository.RepositorioUsuario;
import br.com.trembostore.trembostore.service.ClienteService;
import br.com.trembostore.trembostore.service.ProdutoService;
import br.com.trembostore.trembostore.service.UsuarioService;

@Controller
@RequestMapping("/produto")
public class CadastroProdutoController {

    @Autowired
    private ProdutoService produtoService;

    private RepositorioProduto repositorioProduto;

    @PostMapping("/cadastroProduto")
    public ModelAndView salvarUsuario(@ModelAttribute("dados") Produtos dadosRecebidos,RedirectAttributes redirAttr) {
        
        ModelAndView mv = new ModelAndView("redirect:/cadastrarProduto.html");

        redirAttr.addFlashAttribute("dados", dadosRecebidos);
        System.out.println("cadastrado com sucesso" + dadosRecebidos.getId());

       produtoService.salvarProduto(dadosRecebidos);

        return mv;


    }

    public void setProdutoService(ProdutoService service){
        this.produtoService = service;
    }
}
