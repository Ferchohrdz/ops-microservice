package com.hernandez.springboot.backend.springbootbackendapp.controllers;

import com.hernandez.springboot.backend.springbootbackendapp.models.BaseClienteResponse;
import com.hernandez.springboot.backend.springbootbackendapp.models.entity.Cliente;
import com.hernandez.springboot.backend.springbootbackendapp.services.cliente.IClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${app.cors.origins}")
@Slf4j
public class ClienteRestController {
    private final IClienteService clienteService;

    @Autowired
    public ClienteRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public BaseClienteResponse<List<Cliente>> index() {
        log.info("getClientes API call: {}", clienteService.findAll().toString());
        return ResponseEntity.ok().body(clienteService.findAll()).getBody();
    }

    @GetMapping("/clientes/{id}")
    public BaseClienteResponse<Cliente> show(@PathVariable Long id) {
        log.info("getCliente API call: {}", id);
        return new ResponseEntity<>(clienteService.findClienteById(id), HttpStatus.OK).getBody();
    }

    @PostMapping("/clientes")
    public BaseClienteResponse<?> create(@Valid @RequestBody Cliente cliente, BindingResult bindingResult) {
        log.info("Saving cliente API call: {}", cliente);
        var createClienteResponse = clienteService.save(cliente);
        return new ResponseEntity<>(createClienteResponse, HttpStatus.CREATED).getBody();
    }

    @PutMapping("/clientes/{id}")
    public BaseClienteResponse<Cliente> update(@RequestBody Cliente cliente, @PathVariable Long id) {
        log.info("Updating cliente with id : {}", id);
        var updateClienteResponse = clienteService.updateCliente(cliente, id);
        return new ResponseEntity<>(updateClienteResponse, HttpStatus.CREATED).getBody();
    }

    @DeleteMapping("/clientes/{id}")
    public BaseClienteResponse<?> delete(@PathVariable Long id) {
        log.info("Delete cliente call for id: {}", id);
        var deleteResponse = clienteService.delete(id);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK).getBody();
    }
}
