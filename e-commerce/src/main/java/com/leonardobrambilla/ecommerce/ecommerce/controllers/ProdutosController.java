package com.leonardobrambilla.ecommerce.ecommerce.controllers;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Produtos;
import com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto.ProdutosDTO;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.ProdutosRepository;
import com.leonardobrambilla.ecommerce.ecommerce.services.ProdutosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService produtosService;
    @Autowired
    private ProdutosRepository produtosRepository;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }
    @GetMapping("")
    public List<Produtos> findAll() {
        return produtosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produtos getProduto(@PathVariable Integer id) {
        return produtosRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    @PostMapping("")
    public Produtos salvarProduto(@Valid @RequestBody ProdutosDTO dto) {
        return produtosService.salvar(dto);
    }

    @PutMapping("/{id}")
    public Produtos atualizarProduto(@PathVariable Integer id, @RequestBody ProdutosDTO dto) {
        return produtosService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        produtosService.deletar(id);
    }
}
