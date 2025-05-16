package com.example.employeemanagementsystem.utility;

import com.example.employeemanagementsystem.exception.UserObjectNotCreated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> UserNotFound(UserObjectNotCreated e){
        ErrorStructure<String> errorStructure = ErrorStructure.<String>builder()
                .type("User Exists")
                .status(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorStructure, HttpStatus.CONFLICT);
    }

}
