package br.com.trembostore.trembostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

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

}
