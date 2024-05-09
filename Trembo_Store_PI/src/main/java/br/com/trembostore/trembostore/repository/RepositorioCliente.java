package br.com.trembostore.trembostore.repository;

import br.com.trembostore.trembostore.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository <Cliente, Integer> {
    
}
