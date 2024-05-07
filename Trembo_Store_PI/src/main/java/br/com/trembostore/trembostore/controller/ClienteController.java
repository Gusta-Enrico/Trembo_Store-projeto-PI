package br.com.trembostore.trembostore.controller;

import br.com.trembostore.trembostore.Model.Cliente;
import br.com.trembostore.trembostore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro")
    public ModelAndView salvarCliente(@ModelAttribute("dados")Cliente dadosRecebidos, RedirectAttributes redirAttr){

        ModelAndView mv = new ModelAndView("redirect:/####.html");

        redirAttr.addFlashAttribute("dados", dadosRecebidos);
        System.out.println("Cadastro Realizado" + dadosRecebidos.getCPF());

        clienteService.salvarCliente(dadosRecebidos);

        return mv;
    }

    public void setClienteService(ClienteService service){

    }
}
