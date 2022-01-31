package com.example.demo.exception.handler;

import com.example.demo.exception.AuthenticationException;
import com.example.demo.models.ErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, 422, "Validation Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, 400, "Entity not found", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErrorModel> handleAuthorizationFailure(AuthenticationException ex) {
        ErrorModel error = new ErrorModel(HttpStatus.FORBIDDEN, 403, "Authentication Failed", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
}
