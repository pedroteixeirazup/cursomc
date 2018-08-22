package com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions;

public class ObjectNotFoundExcepetion extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ObjectNotFoundExcepetion(String msg){
        super(msg);
    }

    public ObjectNotFoundExcepetion(String msg , Throwable cause){
        super(msg,cause);
    }
}
