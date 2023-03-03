package com.hernandez.springboot.backend.springbootbackendapp.services.cliente;

import com.hernandez.springboot.backend.springbootbackendapp.models.BaseClienteResponse;
import com.hernandez.springboot.backend.springbootbackendapp.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    BaseClienteResponse<List<Cliente>> findAll();

    BaseClienteResponse<Cliente> findClienteById(Long id);

    BaseClienteResponse<?> save(Cliente cliente);

    BaseClienteResponse<?> delete(Long id);

    BaseClienteResponse<Cliente> updateCliente(Cliente cliente, long id);
}
