package br.com.trembostore.trembostore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.repository.RepositorioUsuario;

@Service
public class UsuarioService {
    

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public UsuarioService(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void salvarUsuario(Usuario usuario) {
        this.repositorioUsuario.save(usuario);
    }

}
