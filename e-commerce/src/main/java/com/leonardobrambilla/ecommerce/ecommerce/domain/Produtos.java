package com.leonardobrambilla.ecommerce.ecommerce.domain;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valorVenda;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false, length = 1000)
    private String img;

    public Produtos() {}

    public Produtos(String nome, String descricao, BigDecimal valorVenda, Integer quantidade, String img) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.img = img;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

