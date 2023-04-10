package com.leonardobrambilla.ecommerce.ecommerce.controllers;
import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto.UsuarioDTO;
import com.leonardobrambilla.ecommerce.ecommerce.services.UsuarioService;
import com.leonardobrambilla.ecommerce.ecommerce.utils.UsuarioSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioSpecification usuarioSpecification;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> listar(@RequestParam(name = "sort", required = false) String sort){
        return this.usuarioService.listar(sort);
    }
    @RequestMapping("/usuarios")
    public List<Usuario> buscarUsuarios(@RequestParam(required = false) String query,
                                        @RequestParam(required = false, defaultValue = "id") String sortBy,
                                        @RequestParam(required = false, defaultValue = "desc") String sortDirection,
                                        @RequestParam(defaultValue = "0") int page) {
        return usuarioService.buscarUsuarios(query, sortBy, sortDirection, page);
    }


    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return this.usuarioService.getUsuario(id);
    }

    @PostMapping("/usuarios")
    public Usuario salvar(@Valid @RequestBody UsuarioDTO dto) {
        Usuario usuario = this.usuarioService.salvar(dto);
        return usuario;
    }
    @PutMapping("usuarios/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody UsuarioDTO dto){
        Usuario atualizado = this.usuarioService.atualizar(id, dto);
        return atualizado;
    }
    @DeleteMapping("/usuarios/{id}")
    public void deletar(@PathVariable Integer id) {
        this.usuarioService.deletar(id);
    }

}
