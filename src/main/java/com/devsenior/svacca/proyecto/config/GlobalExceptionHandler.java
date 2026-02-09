package com.devsenior.svacca.proyecto.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.svacca.proyecto.exception.ProductNotFoundException;
import com.devsenior.svacca.proyecto.exception.ProductoAlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        var response = new ApiErrorResponse();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        return new ResponseEntity<GlobalExceptionHandler.ApiErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductoAlreadyExistException.class)
    public ResponseEntity<ApiErrorResponse> handleProductoAlreadyExistException(ProductoAlreadyExistException ex) {
        var response = new ApiErrorResponse();
        response.setCode(HttpStatus.CONFLICT.value());
        response.setMessage(ex.getMessage());
        return new ResponseEntity<GlobalExceptionHandler.ApiErrorResponse>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        var response = new ApiErrorResponse();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        return new ResponseEntity<ApiErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidExceptio(MethodArgumentNotValidException ex) {
        var response = new ApiErrorResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());

        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        response.setErrors(errors);

        return ResponseEntity.badRequest().body(response);
    }

    private static class ApiErrorResponse {
        private Integer code;
        private String message;
        private Map<String, String> errors;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Map<String, String> getErrors() {
            return errors;
        }

        public void setErrors(Map<String, String> errors) {
            this.errors = errors;
        }
    }
}
