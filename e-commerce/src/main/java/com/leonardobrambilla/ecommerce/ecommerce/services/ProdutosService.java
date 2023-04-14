package com.leonardobrambilla.ecommerce.ecommerce.services;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Produtos;
import com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto.ProdutosDTO;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.ProdutosRepository;
import com.leonardobrambilla.ecommerce.ecommerce.utils.ProdutoSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public Page<Produtos> listar(String filter, int page, int size, String sort, String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortDirection, sort));

        return produtosRepository.findAll(ProdutoSpecifications.filter(filter), pageRequest);
    }


    public Produtos salvar(ProdutosDTO dto) {
        Produtos produtos = this.converterDtoParaProdutos(dto);
        return this.produtosRepository.save(produtos);
    }

    public Produtos atualizar(Integer id, ProdutosDTO dto){
        Optional<Produtos> optionalProdutos = this.produtosRepository.findById(id);
        if (optionalProdutos.isPresent()) {
            Produtos produtos = this.converterDtoParaProdutos(dto);
            produtos.setId(id);
            return this.produtosRepository.save(produtos);
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    public void deletar(Integer id) {
        Optional<Produtos> optionalProdutos = this.produtosRepository.findById(id);
        if (optionalProdutos.isPresent()) {
            this.produtosRepository.delete(optionalProdutos.get());
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    private Produtos converterDtoParaProdutos(ProdutosDTO dto) {
        Produtos produtos = new Produtos();
        produtos.setNome(dto.getNome());
        produtos.setDescricao(dto.getDescricao());
        produtos.setValorVenda(dto.getValorVenda());
        produtos.setQuantidade(dto.getQuantidade());
        produtos.setImg(dto.getImg());
        return produtos;
    }
}
