package br.com.trembostore.trembostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trembostore.trembostore.Model.Usuario;

import java.util.List;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
    Usuario findByEmailAndPassword(String email, String password);

    Usuario findByEmail(String email);
}