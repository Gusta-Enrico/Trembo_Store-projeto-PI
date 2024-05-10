package br.com.trembostore.trembostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.trembostore.trembostore.service.UsuarioService;


@Controller
@RequestMapping("/login")
public class LoginController {
    
    private UsuarioService usuarioService;


    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/logar")
    public String login(String email, String password, Model model) {
        if (usuarioService.verificarCredenciais(email, password) == null) {
            model.addAttribute("erro", "usuario ou senha incorretos");
            return "redirect:/loginfuncionario.html";
            
        } else {
            return "redirect:/PaginaInicio.html";
        }
            
    }
}   
