package com.leonardobrambilla.ecommerce.ecommerce.services;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Usuario>listar() {
        return this.usuarioRepository.findAll();
    }
    public Usuario getUsuario(Integer id){
        Optional<Usuario> usuario = this.usuarioRepository.findAllById(id);
        if(usuario.isEmpty()){
            throw new RuntimeException("Usuário não encontrado");
        }else {
            return usuario.get();
        }
    }
    public Usuario salvar(Usuario novoUsuario){
        novoUsuario.setId(null);
        Usuario usuarioSalvo = this.usuarioRepository.save(novoUsuario);

        return usuarioSalvo;
    }

    public Usuario atualizar(Integer id, Usuario novoUsuario){
        Usuario usuarioAtual = this.getUsuario(id);

        usuarioAtual.setNome(novoUsuario.getNome());
        usuarioAtual.setId(novoUsuario.getId());
        usuarioAtual.setEmail(novoUsuario.getEmail());
        usuarioAtual.setSenha(novoUsuario.getSenha());
        usuarioAtual.setDataCriacao(novoUsuario.getDataCriacao());

        Usuario atualizado = this.usuarioRepository.save(usuarioAtual);

        return atualizado;
    }
    public void deletar(Integer id) {
        Usuario usuario = this.getUsuario(id);
        this.usuarioRepository.delete(usuario);
    }
}
