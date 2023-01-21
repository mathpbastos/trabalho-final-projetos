package edu.ufes.trabalho.model;

import java.time.LocalDate;

public class Usuario {
    
    private long id;
    private String nome;
    private String login;
    private String senha;
    private LocalDate dataCadastro;
    private LocalDate dataModificacao;
    
    
    public Usuario(String nome, 
            String login, 
            String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(long id, 
            String nome, 
            String login, 
            String senha, 
            LocalDate dataCadastro,
            LocalDate dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.dataModificacao = dataModificacao;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
        
}
