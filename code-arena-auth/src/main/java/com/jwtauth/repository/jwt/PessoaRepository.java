package com.jwtauth.repository.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtauth.entity.*;
import com.jwtauth.entity.jwt.Pessoa;;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }