package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<NotFound> handleNotFoundException(NotFoundException notFoundException) {
        System.out.println(notFoundException.getMessage());
        NotFound notFound = new NotFound(notFoundException.getMessage());
        return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
}
