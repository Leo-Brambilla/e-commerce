package com.leonardobrambilla.ecommerce.ecommerce.services;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Clientes;
import com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto.ClientesDTO;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.ClientesRepository;
import com.leonardobrambilla.ecommerce.ecommerce.utils.ClientesSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> listar() {
        return this.clientesRepository.findAll();
    }
    public List<Clientes> listar(String sort) {
        Sort sortOrder = null;
        if(sort != null && !sort.isEmpty()) {
            sortOrder = Sort.by(sort);
        }else {
            sortOrder = Sort.by("id");
        }
        return this.clientesRepository.findAll(sortOrder);
    }
    public List<Clientes> buscarClientes(String query, String sortBy, String sortDirection, int page) {
        Specification<Clientes> spec = Specification.where(null);

        // Adiciona a especificação de busca
        if (query != null && !query.trim().isEmpty()) {
            spec = spec.and(ClientesSpecification.search(query));
        }

        // Adiciona a especificação de ordenação
        if (sortBy != null && !sortBy.trim().isEmpty()) {
            spec = spec.and(ClientesSpecification.sortBy(sortBy, Sort.Direction.fromString(sortDirection)));
        }

        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, "id");
        Page<Clientes> clientes = this.clientesRepository.findAll(spec, pageable);

        return clientes.getContent();
    }

    public Clientes getClientes(Integer id) {
        Optional<Clientes> clientes = this.clientesRepository.findById(id);
        if (clientes.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        } else {
            return clientes.get();
        }
    }

    public Clientes salvar(ClientesDTO dto) {

        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }

        Clientes clientes = new Clientes();
        clientes.setNome(dto.getNome());
        clientes.setSobrenome(dto.getSobrenome());
        clientes.setSexo(dto.getSexo());
        clientes.setDataNascimento(dto.getDataNascimento());
        clientes.setNacionalidade(dto.getNacionalidade());
        clientes.setEndereco(dto.getEndereco());
        clientes.setCidade(dto.getCidade());
        clientes.setEstado(dto.getEstado());
        clientes.setTelefone(dto.getTelefone());
        clientes.setEmail(dto.getEmail());
        clientes.setSenha(dto.getSenha());

        return clientesRepository.save(clientes);
    }

    public Clientes atualizar(Integer id, ClientesDTO dto) {
        Clientes clienteAtual = this.getClientes(id);

        clienteAtual.setId(dto.getId());
        clienteAtual.setNome(dto.getNome());
        clienteAtual.setSobrenome(dto.getSobrenome());
        clienteAtual.setDataNascimento(dto.getDataNascimento());
        clienteAtual.setNacionalidade(dto.getNacionalidade());
        clienteAtual.setEndereco(dto.getEndereco());
        clienteAtual.setCidade(dto.getCidade());
        clienteAtual.setEstado(dto.getEstado());
        clienteAtual.setTelefone(dto.getTelefone());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setSenha(dto.getSenha());


        Clientes atualizado = this.clientesRepository.save(clienteAtual);

        return atualizado;
    }

    public void deletar(Integer id) {
        Clientes clientes = this.getClientes(id);
        this.clientesRepository.delete(clientes);
    }
}
