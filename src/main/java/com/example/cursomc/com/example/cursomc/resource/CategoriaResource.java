package com.example.cursomc.com.example.cursomc.resource;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.CategoriaService;
import com.example.cursomc.com.example.cursomc.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){ //o respondeentiti encapsula uma http para rest

        Optional<Categoria> obj = service.buscar(id);

        return ResponseEntity.ok().body(obj);
    }
}
