package com.leonardobrambilla.ecommerce.ecommerce.services;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto.UsuarioDTO;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.UsuarioRepository;
import com.leonardobrambilla.ecommerce.ecommerce.utils.UsuarioSpecification;
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
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario>listar() {
        return this.usuarioRepository.findAll();
    }
    public List<Usuario> listar(String sort) {
        Sort sortOrder = null;
        if(sort != null && !sort.isEmpty()) {
            sortOrder = Sort.by(sort);
        }else {
            sortOrder = Sort.by("id");
        }

        return this.usuarioRepository.findAll(sortOrder);
    }
    public List<Usuario> buscarUsuarios(String query, String sortBy, String sortDirection, int page) {
        Specification<Usuario> spec = Specification.where(null);

        // Adiciona a especificação de busca
        if (query != null && !query.trim().isEmpty()) {
            spec = spec.and(UsuarioSpecification.search(query));
        }

        // Adiciona a especificação de ordenação
        if (sortBy != null && !sortBy.trim().isEmpty()) {
            spec = spec.and(UsuarioSpecification.sortBy(sortBy, Sort.Direction.fromString(sortDirection)));
        }

        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, "id");
        Page<Usuario> usuarios = this.usuarioRepository.findAll(spec, pageable);

        return usuarios.getContent();
    }
    public Usuario getUsuario(Integer id){
        Optional<Usuario> usuario = this.usuarioRepository.findAllById(id);
        if(usuario.isEmpty()){
            throw new RuntimeException("Usuário não encontrado");
        }else {
            return usuario.get();
        }
    }
    public Usuario salvar(UsuarioDTO dto) {
        // Validar o DTO
        // Se houver algum erro, lançar uma exceção de validação
        // Caso contrário, prosseguir com a conversão e salvamento
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Outras atribuições necessárias

        return usuarioRepository.save(usuario);
    }


    public Usuario atualizar(Integer id, UsuarioDTO dto){
        Usuario usuarioAtual = this.getUsuario(id);

        usuarioAtual.setNome(dto.getNome());
        usuarioAtual.setId(dto.getId());
        usuarioAtual.setEmail(dto.getEmail());
        usuarioAtual.setSenha(dto.getSenha());
        usuarioAtual.setDataCriacao(dto.getDataCriacao());

        Usuario atualizado = this.usuarioRepository.save(usuarioAtual);

        return atualizado;
    }



    public void deletar(Integer id) {
        Usuario usuario = this.getUsuario(id);
        this.usuarioRepository.delete(usuario);
    }
}
