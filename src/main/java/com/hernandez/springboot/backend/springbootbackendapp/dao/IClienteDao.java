package com.hernandez.springboot.backend.springbootbackendapp.dao;

import com.hernandez.springboot.backend.springbootbackendapp.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
