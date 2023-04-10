package com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto;

import java.time.LocalDate;

public class ClientesDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    private String senha;

    public ClientesDTO(){}

    public ClientesDTO(Integer id, String nome, String sobrenome, String sexo, LocalDate dataNascimento, String nacionalidade, String endereco, String cidade, String estado, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
