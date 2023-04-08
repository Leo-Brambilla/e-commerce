package com.leonardobrambilla.ecommerce.ecommerce.repositories;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findAllById(Integer id);
}
