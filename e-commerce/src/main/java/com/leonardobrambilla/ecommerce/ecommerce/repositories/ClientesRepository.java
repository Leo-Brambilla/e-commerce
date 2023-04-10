package com.leonardobrambilla.ecommerce.ecommerce.repositories;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer>, JpaSpecificationExecutor<Clientes> {

}
