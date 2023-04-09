package com.leonardobrambilla.ecommerce.ecommerce.utils;

import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecifications extends SpecificationsUtils<Produtos> {

    @Override
    public Specification<Produtos> search(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (query == null || query.trim().isEmpty()) {
                return null;
            }
            String pattern = "%" + query.trim().toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")), pattern)
            );
        };
    }
}

