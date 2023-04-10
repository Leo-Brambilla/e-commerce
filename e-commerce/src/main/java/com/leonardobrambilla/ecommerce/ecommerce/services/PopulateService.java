package com.leonardobrambilla.ecommerce.ecommerce.services;


import com.leonardobrambilla.ecommerce.ecommerce.domain.Clientes;
import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.ClientesRepository;
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
    private ClientesRepository clienteRepository;
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

            List<Clientes> clientes = Arrays.asList(
                    new Clientes("Ana", "Silva", "F", LocalDate.parse("1985-01-01"), "Brasileira", "Rua A, 123", "São Paulo", "SP", "1199999999", "ana.silva@email.com", "senha123"),
                    new Clientes("João", "Santos", "M", LocalDate.parse("1990-05-10"), "Brasileiro", "Rua B, 456", "Rio de Janeiro", "RJ", "2198888888", "joao.santos@email.com", "senha123"),
                    new Clientes("Pedro", "Ferreira", "M", LocalDate.parse("1988-03-15"), "Português", "Rua C, 789", "Lisboa", "Lisboa", "+351912345678", "pedro.ferreira@email.com", "senha123"),
                    new Clientes("Mariana", "Oliveira", "F", LocalDate.parse("1995-11-22"), "Brasileira", "Rua D, 456", "Salvador", "BA", "7197777777", "mariana.oliveira@email.com", "senha123"),
                    new Clientes("Bruno", "Souza", "M", LocalDate.parse("1992-07-17"), "Brasileiro", "Rua E, 654", "Curitiba", "PR", "4196666666", "bruno.souza@email.com", "senha123"),
                    new Clientes("Fernanda", "Ribeiro", "F", LocalDate.parse("1986-09-08"), "Brasileira", "Rua F, 987", "Belo Horizonte", "MG", "3195555555", "fernanda.ribeiro@email.com", "senha123"),
                    new Clientes("Paulo", "Silveira", "M", LocalDate.parse("1979-12-25"), "Brasileiro", "Rua G, 321", "Porto Alegre", "RS", "5194444444", "paulo.silveira@email.com", "senha123"),
                    new Clientes("Amanda", "Santana", "F", LocalDate.parse("1998-06-02"), "Brasileira", "Rua H, 654", "Fortaleza", "CE", "8593333333", "amanda.santana@email.com", "senha123"),
                    new Clientes("Lucas", "Costa", "M", LocalDate.parse("1993-04-11"), "Brasileiro", "Rua I, 321", "Recife", "PE", "8192222222", "lucas.costa@email.com", "senha123"),
                    new Clientes("Mariza", "Lima", "F", LocalDate.parse("2000-07-17"), "Brasileira", "Rua Fui, 322", "Recife", "PE", "8191222222", "marili@email.com", "senha123")
            );

            clienteRepository.saveAll(clientes);


        }
    }


