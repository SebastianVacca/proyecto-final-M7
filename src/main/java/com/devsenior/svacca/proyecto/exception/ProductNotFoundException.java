package com.devsenior.svacca.proyecto.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
        this("Porducto no encontrado, no existe en el sistema");
    }
    
}
