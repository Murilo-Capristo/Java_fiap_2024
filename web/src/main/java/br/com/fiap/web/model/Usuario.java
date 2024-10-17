package br.com.fiap.web.model;

/*
* CREATE TABLE TBL_USUARIO(
    NOME VARCHAR2(40) NOT NULL,
    LOGIN VARCHAR2(15) PRIMARY KEY NOT NULL,
    SENHA VARCHAR2(512)
);

SELECT * FROM TBL_USUARIO;
*
* */


public class Usuario {

    private String nome;
    private String login;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}