package com.devsenior.svacca.proyecto.exception;

public class ProductoAlreadyExistException extends RuntimeException{
    public ProductoAlreadyExistException(String message) {
        super(message);
    }

    public ProductoAlreadyExistException() {
        this("El producto ya se encuentra registrado en el sistema");
    }
}
