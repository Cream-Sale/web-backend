package com.creamsale.exception;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProblemDetailControllerAdvice {

    @ExceptionHandler(value = { Throwable.class })
    protected ResponseEntity<?> toProblemDetail(Throwable throwable) {
        ProblemDetail detail = ProblemDetail.builder(throwable).build();

        return ResponseEntity.status(detail.getStatus())
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(detail);
    }

}
