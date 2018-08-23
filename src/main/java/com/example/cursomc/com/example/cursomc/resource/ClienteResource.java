package com.example.cursomc.com.example.cursomc.resource;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.ClienteService;
import com.example.cursomc.com.example.cursomc.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){ //o respondeentiti encapsula uma http para rest
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
