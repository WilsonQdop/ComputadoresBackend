package com.Github.WilsonQdop.Computadores.controllers;

import com.Github.WilsonQdop.Computadores.exceptions.HardwareNotFoundException;
import com.Github.WilsonQdop.Computadores.exceptions.SetupNotFoundException;
import com.Github.WilsonQdop.Computadores.exceptions.UserNotFoundException;
import com.Github.WilsonQdop.Computadores.exceptions.infra.StandardMessageError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<StandardMessageError> userNotFoundHandler (UserNotFoundException userException) {
        StandardMessageError threatMessage = new StandardMessageError(HttpStatus.NOT_FOUND, userException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }

    @ExceptionHandler(SetupNotFoundException.class)
    private ResponseEntity<StandardMessageError> setupNotFoundHandler (SetupNotFoundException setupException) {
        StandardMessageError threatMessage = new StandardMessageError(HttpStatus.NOT_FOUND, setupException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }

    @ExceptionHandler(HardwareNotFoundException.class)
    private ResponseEntity<StandardMessageError> hardwareNotFoundHandler (HardwareNotFoundException hardwareException) {
        StandardMessageError threatMessage = new StandardMessageError(HttpStatus.NOT_FOUND, hardwareException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatMessage);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<StandardMessageError> argumentMismatch () {
        StandardMessageError threatMessage = new StandardMessageError(HttpStatus.BAD_REQUEST, "Argumento inválido");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<StandardMessageError> duplicateMethod () {
        StandardMessageError threatMessage = new StandardMessageError(HttpStatus.CONFLICT, "Email duplicado");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatMessage);
    }

}
