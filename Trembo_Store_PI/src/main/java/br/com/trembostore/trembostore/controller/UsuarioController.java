package br.com.trembostore.trembostore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.trembostore.trembostore.Model.Usuario;
import br.com.trembostore.trembostore.repository.RepositorioUsuario;
import br.com.trembostore.trembostore.service.UsuarioService;


@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario usuario = usuarioService.getUserById(id);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.updateUsuario(id, usuario);
        if (usuarioAtualizado != null)
            return ResponseEntity.ok((usuarioAtualizado));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Usuario> updateStatusUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.updateStatusUsuario(id, usuario.getStatus());
        if (usuarioAtualizado != null){
            return ResponseEntity.ok(usuarioAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        String msg = usuarioService.deleteUsuario(id);
        if (msg.contains("deletado")){
            return ResponseEntity.ok(msg);
        }
         return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuarioLogado){
        Usuario usuario = usuarioService.findByEmail(usuarioLogado.getEmail());

        if (usuario != null && usuarioLogado.getSenha().equals(usuario.getSenha())) {
            if (usuario.getStatus().equals("ativo")) {
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}
