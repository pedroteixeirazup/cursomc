package com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories;

import com.example.cursomc.com.example.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
