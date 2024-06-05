package br.com.trembostore.trembostore.repository;

import org.springframework.stereotype.Repository;

import br.com.trembostore.trembostore.Model.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositorioProduto extends JpaRepository<Produtos, Integer>{

}
