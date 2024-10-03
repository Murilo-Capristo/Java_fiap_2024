package br.com.fiap.java.challenge.model;

import java.util.Scanner;

public class Cliente extends Pessoa{
    private int id;
    private String cpf;
    private String telefone;
    private String senha;

    public Cliente() {}

    public Cliente(String nome, String email, String cpf, String telefone, String senha) {
        super(nome, email);
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome +
                "\nEmail: " + this.email +
                "\nCPF: " + this.cpf +
                "\nTelefone: " + this.telefone +
                "\nSenha: " + this.senha);
    }
}

