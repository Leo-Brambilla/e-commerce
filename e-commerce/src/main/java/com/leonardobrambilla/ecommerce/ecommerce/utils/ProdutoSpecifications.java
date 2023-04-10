package com.leonardobrambilla.ecommerce.ecommerce.utils;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Produtos;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProdutoSpecifications{
    public static Specification<Produtos> filter(String filter) {
        return new Specification<Produtos>() {
            @Override
            public Predicate toPredicate(Root<Produtos> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (!StringUtils.isEmpty(filter)) {
                    String[] filters = filter.split(";");

                    for (String filterString : filters) {
                        String[] filterArray = filterString.split(":");
                        String field = filterArray[0];
                        String value = filterArray[1];

                        predicates.add(cb.and(buscarPorCampo(field, value).toPredicate(root, query, cb)));
                    }
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }

    public static Specification<Produtos> buscarPorCampo(String campo, String valor) {
        return new Specification<Produtos>() {
            @Override
            public Predicate toPredicate(Root<Produtos> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (campo.equals("id")) {
                    return criteriaBuilder.equal(root.get("id"), valor);
                } else if (campo.equals("nome")) {
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + valor.toLowerCase() + "%");
                } else if (campo.equals("descricao")) {
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")), "%" + valor.toLowerCase() + "%");
                } else if (campo.equals("valorVenda")) {
                    return criteriaBuilder.equal(root.get("valorVenda"), valor);
                } else if (campo.equals("quantidade")) {
                    return criteriaBuilder.equal(root.get("quantidade"), valor);
                }
                return null;
            }
        };
    }

    public static Specification<Produtos> ordenarPorCampo(String campo, String direcao) {
        return new Specification<Produtos>() {
            @Override
            public Predicate toPredicate(Root<Produtos> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (direcao.equals("asc")) {
                    query.orderBy(criteriaBuilder.asc(root.get(campo)));
                } else if (direcao.equals("desc")) {
                    query.orderBy(criteriaBuilder.desc(root.get(campo)));
                }
                return null;
            }
        };
    }


}

