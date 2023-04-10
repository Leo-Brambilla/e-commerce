package com.leonardobrambilla.ecommerce.ecommerce.repositories;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer>, JpaSpecificationExecutor<Produtos> {

    @Override
    Page<Produtos> findAll(Specification<Produtos> spec, Pageable pageable);

}
