package br.com.trembostore.trembostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trembostore.trembostore.Model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
    Usuario findByEmailAndPassword(String email, String password);
}