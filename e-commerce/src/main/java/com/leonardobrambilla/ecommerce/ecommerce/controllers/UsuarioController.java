package com.leonardobrambilla.ecommerce.ecommerce.controllers;
import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> listar(){
    return this.usuarioService.listar();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return this.usuarioService.getUsuario(id);
    }

    @PostMapping("/usuarios")
    public Usuario salvar(@RequestBody Usuario usuario){
        Usuario salvo = this.usuarioService.salvar(usuario);
        return salvo;
    }
    @PutMapping("usuarios/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario atualizado = this.usuarioService.atualizar(id, usuario);
        return atualizado;
    }
    @DeleteMapping("/usuarios/{id}")
    public void deletar(@PathVariable Integer id) {
        this.usuarioService.deletar(id);
    }

}
