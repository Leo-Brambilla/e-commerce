package com.leonardobrambilla.ecommerce.ecommerce.utils;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public abstract class SpecificationsUtils<T> {
    public abstract Specification<T> search(String query);

    public Specification<T> sortBy(String field, Sort.Direction direction) {
        return (root, query, builder) -> {
            query.orderBy(direction == Sort.Direction.ASC ? builder.asc(root.get(field)) : builder.desc(root.get(field)));
            return null;
        };
    }
}
