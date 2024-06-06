package br.com.trembostore.trembostore.controller;

import br.com.trembostore.trembostore.Model.Cliente;
import br.com.trembostore.trembostore.Model.ClienteDTO;
import br.com.trembostore.trembostore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> clienteComEnderecoFaturamento(@RequestBody ClienteDTO clienteDTO){
        Cliente novoCliente = clienteService.ClienteComEnderecoFaturamento(clienteDTO.getCliente(), clienteDTO.getEnderecoFaturamento());
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }


    public void setClienteService(ClienteService service){
        this.clienteService = service;
    }


}
