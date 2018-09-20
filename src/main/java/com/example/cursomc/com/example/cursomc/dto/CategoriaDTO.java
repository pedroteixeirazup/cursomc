package com.example.cursomc.com.example.cursomc.dto;

import com.example.cursomc.com.example.cursomc.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L; //filtra o que eu quero mostrar
    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório.")
    @Length(min = 5, max = 80,message = "O tamanho deve ser entre 5 e 80 caracteres.")
    private  String nome;


    public CategoriaDTO(Categoria obj) {

        id = obj.getId();
        nome = obj.getNome();
    }


    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

















