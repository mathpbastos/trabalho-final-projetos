package edu.ufes.trabalho.model;

import java.time.LocalDate;

public class Usuario {
    
    private long id;
    private String nome;
    private String login;
    private String senha;
    private LocalDate dataCadastro;
    private LocalDate dataModificacao;
    private boolean administrador;
    private boolean autorizado = false;
    
    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String nome, 
            String login, 
            String senha,
            boolean administrador) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.administrador = administrador;
    }
    
    public Usuario(String nome, 
            String login, 
            String senha,
            boolean administrador,
            boolean autorizado) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.administrador = administrador;
        this.autorizado = autorizado;
    }

    public Usuario(long id, 
            String nome, 
            String login, 
            String senha, 
            LocalDate dataCadastro,
            LocalDate dataModificacao,
            boolean administrador) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.dataModificacao = dataModificacao;
        this.administrador = administrador;
    }
    
    public Usuario(long id, 
            String nome, 
            String login, 
            String senha, 
            LocalDate dataCadastro,
            LocalDate dataModificacao,
            boolean administrador,
            boolean autorizado) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.dataModificacao = dataModificacao;
        this.administrador = administrador;
        this.autorizado = autorizado;
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

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    
    public boolean isAdministrador(){
        return this.administrador;
    }
      
    public boolean isAutorizado(){
        return this.autorizado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
    
    @Override
    public String toString(){
        return "Id: " + this.id
                + "\nNome: " + this.nome
                + "\nLogin: " + this.login
                + "\nSenha: " + this.senha
                + "\nData Cadastro: " + this.dataCadastro
                + "\nData Mod: " + this.dataModificacao
                + "\nAdministrador: " + this.administrador
                + "\nAutorizado: " + this.autorizado;
    }
    
}
