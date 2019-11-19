package com.auth.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.crm.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
