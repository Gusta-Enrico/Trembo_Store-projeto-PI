package br.com.trembostore.trembostore.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "email_cli", unique = true)
    private String email_cli;
    private String data_Nascimento;
    private String senha;
    private String genero;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_entrega_id", referencedColumnName = "id")
    private EnderecoEntrega enderecoEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_faturamento_id", referencedColumnName = "id")
    private EnderecoFaturamento enderecoFaturamento;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String email_cli, String data_Nascimento, String senha, String genero, EnderecoEntrega enderecoEntrega, EnderecoFaturamento enderecoFaturamento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email_cli = email_cli;
        this.data_Nascimento = data_Nascimento;
        this.senha = senha;
        this.genero = genero;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String emailCli) {
        this.email_cli = emailCli;
    }

    public String getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(String data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EnderecoFaturamento getEnderecoFaturamento() {
        return enderecoFaturamento;
    }

    public void setEnderecoFaturamento(EnderecoFaturamento enderecoFaturamento) {
        this.enderecoFaturamento = enderecoFaturamento;
    }



}
