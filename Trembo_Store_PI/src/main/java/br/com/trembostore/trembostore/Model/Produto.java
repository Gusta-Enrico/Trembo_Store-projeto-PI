package br.com.trembostore.trembostore.Model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private double preco;

    private String marca;

    private String status;

    private double avaliacao;

    private int qtdProduto;
    
    private String descricao;
    
    private String imagem;

    @ElementCollection
    private List<String> listaImagens;




    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public double getAvaliacao() {
        return avaliacao;
    }


    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }


    public int getQtdProduto() {
        return qtdProduto;
    }


    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getImagem() {
        return imagem;
    }


    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


    public List<String> getListaImagens() {
        return listaImagens;
    }


    public void setListaImagens(List<String> listaImagens) {
        this.listaImagens = listaImagens;
    }

    

    public Produto(Long id, String nome, String categoria, double preco, String marca, double avaliacao, int qtdProduto,
            String descricao, String imagem, List<String> listaImagens) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.marca = marca;
        this.avaliacao = avaliacao;
        this.qtdProduto = qtdProduto;
        this.descricao = descricao;
        this.imagem = imagem;
        this.listaImagens = listaImagens;
    }


    
    public Produto() {
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    

    

    

    





}
