package com.hernandez.springboot.backend.springbootbackendapp.services.cliente;

import com.hernandez.springboot.backend.springbootbackendapp.dao.IClienteDao;
import com.hernandez.springboot.backend.springbootbackendapp.models.BaseClienteResponse;
import com.hernandez.springboot.backend.springbootbackendapp.models.entity.Cliente;
import com.hernandez.springboot.backend.springbootbackendapp.services.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;

    @Autowired
    public ClienteServiceImpl(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    @Transactional
    public BaseClienteResponse<List<Cliente>> findAll() {
        final var clientes = clienteDao.findAll();
        return new BaseClienteResponse<>(null, clientes);
    }


    @Override
    public BaseClienteResponse<Cliente> findClienteById(Long id) {
        final var cliente = clienteDao.findById(id).orElseThrow(() -> new ServiceException(String.format("Cliente with id {%d} not found", id)));
        return new BaseClienteResponse<>(null, cliente);
    }

    @Override
    @Transactional
    public BaseClienteResponse<Cliente> save(Cliente cliente) {
        clienteDao.save(cliente);
        return new BaseClienteResponse<>("¡El cliente ha sido guardado con éxito!", cliente);
    }

    @Override
    @Transactional
    public BaseClienteResponse<?> delete(Long id) {
        clienteDao.deleteById(id);
        return new BaseClienteResponse<>("¡El cliente ha sido eliminado con éxito!", null);
    }

    @Override
    @Transactional
    public BaseClienteResponse<Cliente> updateCliente(Cliente cliente, long id) {
        var clienteActual = clienteDao.findById(id).orElseThrow(() -> new ServiceException(String.format("Cliente with id {%d} not found", id)));
        BeanUtils.copyProperties(cliente, clienteActual);
        return new BaseClienteResponse<>("¡El cliente ha sido actualizado con éxito!", clienteActual);
    }
}
