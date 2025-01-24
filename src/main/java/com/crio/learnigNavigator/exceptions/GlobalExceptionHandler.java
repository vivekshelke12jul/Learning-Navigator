package com.crio.learnigNavigator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private record ErrorDetails(LocalDateTime timestamp, String message, String description) {}

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDetails> handleResponseStatusException(ResponseStatusException exception, WebRequest req){

        HttpStatus status = (HttpStatus)exception.getStatusCode();

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
//                exception.getClass().getSimpleName(),
                exception.getBody().getDetail(),
                req.getDescription(false));

        return new ResponseEntity<>(errorDetails, status);
    }
}
