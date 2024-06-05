package br.com.trembostore.trembostore.service;

import br.com.trembostore.trembostore.Model.Cliente;
import br.com.trembostore.trembostore.Model.EnderecoFaturamento;
import br.com.trembostore.trembostore.repository.RepositorioCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private RepositorioCliente repositorioCliente;


    public Cliente ClienteComEnderecoFaturamento(Cliente cliente, EnderecoFaturamento enderecoFaturamento) {
        cliente.setEnderecoFaturamento(enderecoFaturamento);
        return repositorioCliente.save(cliente);

    /*public void salvarCliente(Cliente cliente){
        this.repositorioCliente.save(cliente);
    }*/
    }
}

