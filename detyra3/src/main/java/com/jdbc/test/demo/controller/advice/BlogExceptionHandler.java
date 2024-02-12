package com.jdbc.test.demo.controller.advice;

import com.jdbc.test.demo.exception.CategoryNotFoundException;
import com.jdbc.test.demo.exception.PostNotFoundException;
import com.jdbc.test.demo.exception.UserNotFoundException;
import com.jdbc.test.demo.exception.model.ExceptionResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> handleUserNotFoundException(
            UserNotFoundException ex, HttpServletRequest req){
        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> handlePostNotFoundException(
            PostNotFoundException ex, HttpServletRequest req){
        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> handleCategoryNotFoundException(
            CategoryNotFoundException ex, HttpServletRequest req){
        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }
}
