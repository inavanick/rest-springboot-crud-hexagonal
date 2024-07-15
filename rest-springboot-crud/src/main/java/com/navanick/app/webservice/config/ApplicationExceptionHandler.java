package com.navanick.app.webservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.navanick.lib.people.EntityNotFoundException;

@RestControllerAdvice
class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ProblemDetail> handleEntityNotFound(EntityNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        return ResponseEntity.of(problemDetail).build();
    }
}