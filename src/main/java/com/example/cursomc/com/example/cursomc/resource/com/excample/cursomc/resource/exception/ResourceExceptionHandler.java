package com.example.cursomc.com.example.cursomc.resource.com.excample.cursomc.resource.exception;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.DataIntegityException;
import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.ObjectNotFoundExcepetion;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExcepetion.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcepetion e, HttpServletRequest request){

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }


    @ExceptionHandler(DataIntegityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegityException e, HttpServletRequest request){

        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){

        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação;",System.currentTimeMillis());

        for(FieldError x: e.getBindingResult().getFieldErrors()){

            err.addError(x.getField(),x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
