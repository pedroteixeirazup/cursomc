package com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories;

import com.example.cursomc.com.example.cursomc.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


}
