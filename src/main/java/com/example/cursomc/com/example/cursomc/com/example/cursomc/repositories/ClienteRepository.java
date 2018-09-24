package com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories;

import com.example.cursomc.com.example.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    Cliente findByEmail(String email); // o spring data cria sozinho a busca por email.

}
