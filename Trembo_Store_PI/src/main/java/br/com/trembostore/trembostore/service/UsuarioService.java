package br.com.trembostore.trembostore.service;

import br.com.trembostore.trembostore.Model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.repository.RepositorioUsuario;

import java.util.List;

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

    public Usuario verificarCredenciais(String email, String password) {
        return repositorioUsuario.findByEmailAndPassword(email, password);
    }

    public void deletarFuncionario(Long id) {
        repositorioUsuario.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Usuario buscarUsuarioPorId (long id){
        return repositorioUsuario.findById(id).orElse(null);
    }

}
