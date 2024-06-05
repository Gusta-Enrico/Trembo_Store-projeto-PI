package br.com.trembostore.trembostore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.repository.RepositorioUsuario;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired                      
    private RepositorioUsuario repositorioUsuario;

   public List<Usuario> getAllUsuarios(){
       return repositorioUsuario.findAll();
   }

   public Usuario getUserById(Long id){
       return repositorioUsuario.findById(id).orElse(null);
   }

   public Usuario createUsuario(Usuario usuario){
       return repositorioUsuario.save(usuario);
   }

   public Usuario updateUsuario(Long id, Usuario usuario){
       Usuario usuarioExistente = getUserById(id);
       if (usuarioExistente != null){
           usuarioExistente.setNome(usuario.getNome());
           usuarioExistente.setEmail(usuario.getEmail());
           usuarioExistente.setCpf(usuario.getCpf());
           usuarioExistente.setSenha(usuario.getSenha());
           usuarioExistente.setConfirmarSenha(usuario.getConfirmarSenha());
           usuarioExistente.setCargo(usuario.getCargo());
           usuarioExistente.setStatus(usuario.getStatus());
           return repositorioUsuario.save(usuarioExistente);
       }
       return null;
   }

   public String deleteUsuario(Long id){
       Usuario usuarioExistente = getUserById(id);
       if (usuarioExistente != null){
           usuarioExistente.setStatus("Deletado");
           repositorioUsuario.save(usuarioExistente);
           return "Usuario com Id" + id + " foi deletado";
       }
       return "Usuario com id " + "não foi encontrado";
   }

   public Usuario updateStatusUsuario(Long id, String status){
       Usuario usuarioExistente = getUserById(id);
       if (usuarioExistente != null){
           usuarioExistente.setStatus(status);
           return repositorioUsuario.save(usuarioExistente);
       }
       return null;
   }

   public Usuario findByEmail(String email){
       return repositorioUsuario.findByEmail(email);
   }
   
}
