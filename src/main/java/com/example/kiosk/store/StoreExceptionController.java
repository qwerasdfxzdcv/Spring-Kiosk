package com.example.kiosk.store;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreExceptionController {
    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<?> storeNotFoundHandler(StoreNotFoundException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
