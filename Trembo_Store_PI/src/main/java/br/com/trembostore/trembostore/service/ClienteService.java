package br.com.trembostore.trembostore.service;

import br.com.trembostore.trembostore.Model.Cliente;
import br.com.trembostore.trembostore.repository.RepositorioCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private RepositorioCliente repositorioCliente;

    @Autowired
    public ClienteService(RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public void salvarCliente(Cliente cliente){
        this.repositorioCliente.save(cliente);
    }
}
