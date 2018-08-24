package com.example.cursomc.com.example.cursomc.resource;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.PedidoService;
import com.example.cursomc.com.example.cursomc.domain.Cliente;
import com.example.cursomc.com.example.cursomc.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id){ //o respondeentiti encapsula uma http para rest
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
