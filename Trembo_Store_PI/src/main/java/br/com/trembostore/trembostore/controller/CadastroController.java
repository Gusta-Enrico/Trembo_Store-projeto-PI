package br.com.trembostore.trembostore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.repository.RepositorioUsuario;
import br.com.trembostore.trembostore.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuario")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    private RepositorioUsuario repositorioUsuario;

    @PostMapping("/cadastro")
    public ModelAndView salvarUsuario(@ModelAttribute("dados") Usuario dadosRecebidos,RedirectAttributes redirAttr) {

        ModelAndView mv = new ModelAndView("redirect:/loginfuncionario.html");

        redirAttr.addFlashAttribute("dados", dadosRecebidos);
        System.out.println("cadastrado com sucesso" + dadosRecebidos.getCpf());

       usuarioService.salvarUsuario(dadosRecebidos);

        return mv;


    }

    public void setUsuarioservice(UsuarioService service){
        this.usuarioService = service;
    }

    @GetMapping({"", "/"})
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    public String listaFuncionario (Model model) {
        List<Usuario> usuarios = repositorioUsuario.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios.html";
    }


}
