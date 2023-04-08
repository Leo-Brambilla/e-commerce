package com.leonardobrambilla.ecommerce.ecommerce.services;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PopulateService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void populate(){
        Usuario u1 = new Usuario(null, "Leonardo", "leo@example.com", "123456", LocalDate.now());
        Usuario u2 = new Usuario(null, "Gabriele", "gabs@example.com", "789012", LocalDate.now());
        Usuario u3 = new Usuario(null, "Pietra", "pi@example.com", "345678", LocalDate.now());
        Usuario u4 = new Usuario(null, "Isabela", "isa@example.com", "901234", LocalDate.now());
        Usuario u5 = new Usuario(null, "Cristina", "cris@example.com", "567890", LocalDate.now());
        Usuario u6 = new Usuario(null, "Vanderley", "tum@example.com", "112456", LocalDate.now());
        Usuario u7 = new Usuario(null, "Ricardo", "ric@example.com", "113456", LocalDate.now());
        Usuario u8 = new Usuario(null, "Viviane", "vivi@example.com", "111456", LocalDate.now());
        Usuario u9 = new Usuario(null, "Luzia", "lulu@example.com", "111156", LocalDate.now());
        Usuario u10 = new Usuario(null, "Felipe", "fe@example.com", "111116", LocalDate.now());

        this.usuarioRepository.save(u1);
        this.usuarioRepository.save(u2);
        this.usuarioRepository.save(u3);
        this.usuarioRepository.save(u4);
        this.usuarioRepository.save(u5);
        this.usuarioRepository.save(u6);
        this.usuarioRepository.save(u7);
        this.usuarioRepository.save(u8);
        this.usuarioRepository.save(u9);
        this.usuarioRepository.save(u10);
    }
}
