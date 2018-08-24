package com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions;

public class DataIntegityException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public DataIntegityException(String msg){
        super(msg);
    }

    public DataIntegityException(String msg , Throwable cause){
        super(msg,cause);
    }
}
