package com.leonardobrambilla.ecommerce.ecommerce.utils;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Clientes;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ClientesSpecification {
    public static Specification<Clientes> search(String query) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (query == null || query.trim().isEmpty()) {
                return null;
            }
            String pattern = "%" + query.trim().toLowerCase() + "%";
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("sobrenome")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("sexo")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("dataNascimento")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nacionalidade")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("endereco")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("cidade")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("estado")), pattern),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("telefone")), pattern),
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
