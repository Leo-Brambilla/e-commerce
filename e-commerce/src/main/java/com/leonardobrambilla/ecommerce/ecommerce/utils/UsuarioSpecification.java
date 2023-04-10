package com.leonardobrambilla.ecommerce.ecommerce.utils;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UsuarioSpecification {

    public static Specification<Usuario> search(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (query == null || query.trim().isEmpty()) {
                return null;
            }
            String pattern = "%" + query.trim().toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), pattern)
            );
        };
    }

    public static <T> Specification<T> sortBy(String field, Sort.Direction direction) {
        return (root, query, builder) -> {
            query.orderBy(direction == Sort.Direction.ASC ? builder.asc(root.get(field)) : builder.desc(root.get(field)));
            return null;
        };
    }
}