package com.interview.seb.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<Object> handleInputExceptions(RuntimeException ex) {
        return ResponseEntity.badRequest().body(new RestError(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    static class RestError{
        private final HttpStatus code;
        private final String message;
        private final LocalDateTime datetime;

        public RestError(HttpStatus code, String message) {
            this.code = code;
            this.message = message;
            this.datetime = LocalDateTime.now();
        }

        public HttpStatus getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public LocalDateTime getDatetime() {
            return datetime;
        }
    }
}
