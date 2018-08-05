package com.example.demo.controller.base;

import com.example.demo.data.model.Message;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    @ExceptionHandler({AccessDeniedException.class})
    public final ResponseEntity handleAccessDeniedException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .build();
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    public final ResponseEntity handleIllegalException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new Message(ex.getLocalizedMessage()));
    }

    @ResponseBody
    @ExceptionHandler(value = {ResourceNotFoundException.class, FileNotFoundException.class})
    public final ResponseEntity notFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllExceptions(Exception ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new Message(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public final ResponseEntity handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UnsupportedMediaTypeStatusException.class)
    public final ResponseEntity unsupportedMediaTypeStatusException(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
    }
}
