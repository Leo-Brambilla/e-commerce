package com.leonardobrambilla.ecommerce.ecommerce.controllers;

import com.leonardobrambilla.ecommerce.ecommerce.domain.Clientes;
import com.leonardobrambilla.ecommerce.ecommerce.domain.Usuario;
import com.leonardobrambilla.ecommerce.ecommerce.domain.enums.dto.ClientesDTO;
import com.leonardobrambilla.ecommerce.ecommerce.services.ClientesService;
import com.leonardobrambilla.ecommerce.ecommerce.utils.ClientesSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientesController {
    @Autowired
    private ClientesService clientesService;
    @Autowired
    private ClientesSpecification clientesSpecification;

    public ClientesController(ClientesService clientesService){
        this.clientesService = clientesService;
    }

    @GetMapping("/clientes")
    public List<Clientes> findAllClientes() {
        return clientesService.listar();
    }

    @GetMapping("/clientes/listar")
    public List<Clientes> listar(@RequestParam(name = "sort", required = false) String sort){
        return this.clientesService.listar(sort);
    }

    @RequestMapping("/clientes")
    public List<Clientes> buscarClientes(@RequestParam(required = false) String query,
                                        @RequestParam(required = false, defaultValue = "id") String sortBy,
                                        @RequestParam(required = false, defaultValue = "desc") String sortDirection,
                                        @RequestParam(defaultValue = "0") int page) {
        return clientesService.buscarClientes(query, sortBy, sortDirection, page);
    }

    @GetMapping("/clientes/{id}")
    public Clientes getClientes(@PathVariable Integer id){
        return this.clientesService.getClientes(id);
    }

    @PostMapping("/clientes")
    public Clientes salvar(@Valid @RequestBody ClientesDTO dto) {
        Clientes clientes = this.clientesService.salvar(dto);
        return clientes;
    }
    @PutMapping("clientes/{id}")
    public Clientes atualizar(@PathVariable Integer id, @RequestBody ClientesDTO dto){
        Clientes atualizado = this.clientesService.atualizar(id, dto);
        return atualizado;
    }
    @DeleteMapping("/clientes/{id}")
    public void deletar(@PathVariable Integer id) {
        this.clientesService.deletar(id);
    }

}
