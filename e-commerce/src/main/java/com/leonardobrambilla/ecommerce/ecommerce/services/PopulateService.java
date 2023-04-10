package com.leonardobrambilla.ecommerce.ecommerce.services;


import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

@Service
public class PopulateService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
        public void populate() {
            // Criar usuários fictícios
            List<Usuario> usuarios = Arrays.asList(
                    new Usuario(null, "Fulano da Silva", "fulano@email.com", "123456",
                            LocalDate.of(2022, 1, 1)),
                    new Usuario(null, "Ciclano Souza", "ciclano@email.com", "123456",
                            LocalDate.of(2022, 2, 1)),
                    new Usuario(null, "Beltrano Santos", "beltrano@email.com", "123456",
                            LocalDate.of(2022, 3, 1)),
                    new Usuario(null, "José Pereira", "jose@email.com", "123456",
                            LocalDate.of(2022, 4, 1)),
                    new Usuario(null, "Maria Oliveira", "maria@email.com", "123456",
                            LocalDate.of(2022, 5, 1)),
                    new Usuario(null, "Pedro Rocha", "pedro@email.com", "123456",
                            LocalDate.of(2022, 6, 1)),
                    new Usuario(null, "Joana Ferreira", "joana@email.com", "123456",
                            LocalDate.of(2022, 7, 1)),
                    new Usuario(null, "Roberto Alves", "roberto@email.com", "123456",
                            LocalDate.of(2022, 8, 1)),
                    new Usuario(null, "Luciana Costa", "luciana@email.com", "123456",
                            LocalDate.of(2022, 9, 1)),
                    new Usuario(null, "Rafaela Santos", "rafaela@email.com", "123456",
                            LocalDate.of(2022, 10, 1))
            );
            usuarioRepository.saveAll(usuarios);
        }
    }


