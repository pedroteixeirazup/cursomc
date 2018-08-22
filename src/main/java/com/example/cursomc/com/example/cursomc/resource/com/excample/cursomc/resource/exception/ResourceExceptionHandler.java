package com.example.cursomc.com.example.cursomc.resource.com.excample.cursomc.resource.exception;

import com.example.cursomc.com.example.cursomc.com.example.cursomc.services.com.example.cursomc.services.exceptions.ObjectNotFoundExcepetion;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundExcepetion.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcepetion e, HttpServletRequest request){

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
