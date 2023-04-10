package com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto;

import java.time.LocalDate;

public class UsuarioDTO {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCriacao;

    public UsuarioDTO() {}

    public UsuarioDTO(Integer id, String nome, String email, String senha,LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {return senha;}
    public void setSenha(String senha){this.senha = senha;}

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
