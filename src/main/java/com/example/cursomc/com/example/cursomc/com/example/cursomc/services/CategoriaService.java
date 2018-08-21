package com.example.cursomc.com.example.cursomc.com.example.cursomc.services;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.com.example.cursomc.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Optional<Categoria> buscar(Integer id){

        Optional<Categoria> obj = repo.findById(id);

        return obj;
    }

}
