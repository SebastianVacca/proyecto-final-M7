package com.devsenior.svacca.proyecto.model.dto;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;

public class ProductoRequest {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El precio es requerido")
    private Double precio;

    private Double descripcion;

    @NotBlank(message = "El tag del producto es requerido")
    private List<String> tags;

    @Field("especificaciones")
    private Map<String, Object> especificaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Double descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(Map<String, Object> especificaciones) {
        this.especificaciones = especificaciones;
    }
}
