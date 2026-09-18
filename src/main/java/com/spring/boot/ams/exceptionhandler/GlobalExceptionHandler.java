package com.spring.boot.ams.exceptionhandler;

import com.spring.boot.ams.errorstructure.ErrorStructure;
import com.spring.boot.ams.exception.ActorNotFoundByIdException;
import com.spring.boot.ams.exception.ActorNotFoundByNameException;
import com.spring.boot.ams.exception.ActorNotFoundException;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleActorNotFoundException(ActorNotFoundException ex){
        ErrorStructure<String> es = new ErrorStructure<>();
        es.setErrorCode(HttpStatus.NOT_FOUND.value());
        es.setErrorMessage(ex.getMessage());
        es.setError("Actors not found hence the input is invalid");
        return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleActorNotFoundByIdException(ActorNotFoundByIdException ex){
        ErrorStructure<String> es = new ErrorStructure<>();
        es.setErrorCode(HttpStatus.NOT_FOUND.value());
        es.setErrorMessage(ex.getMessage());
        es.setError("Actor not found hence the input is invalid");
        return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleActorNotFoundByNameException(ActorNotFoundByNameException ex){
        ErrorStructure<String> es = new ErrorStructure<>();
        es.setErrorCode(HttpStatus.NOT_FOUND.value());
        es.setErrorMessage(ex.getMessage());
        es.setError("Actor not found hence the input is invalid");
        return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);
    }
}
