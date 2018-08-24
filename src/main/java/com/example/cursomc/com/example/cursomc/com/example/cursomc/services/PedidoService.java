package com.example.cursomc.com.example.cursomc.com.example.cursomc.services;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.PedidoRepository;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.ObjectNotFoundExcepetion;
import com.example.cursomc.com.example.cursomc.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;


        public Pedido buscar(Integer id) {
            Optional<Pedido> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundExcepetion(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
        }

}
