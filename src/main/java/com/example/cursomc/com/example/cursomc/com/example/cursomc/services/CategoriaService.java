package com.example.cursomc.com.example.cursomc.com.example.cursomc.services;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.DataIntegityException;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.ObjectNotFoundExcepetion;
import com.example.cursomc.com.example.cursomc.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;


        public Categoria find(Integer id) {
            Optional<Categoria> obj = repo.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundExcepetion(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }

        public Categoria insert(Categoria obj){

            obj.setId(null);

            return repo.save(obj);
        }

        public Categoria update(Categoria obj){
            find(obj.getId());
            return repo.save(obj);
        }

        public void delete(Integer id){
            find(id);
            try {
                repo.deleteById(id);
            }catch(DataIntegrityViolationException e){

                throw new DataIntegityException("Não é possivel excluir uma categoria que possui produtos");
            }
        }
}
