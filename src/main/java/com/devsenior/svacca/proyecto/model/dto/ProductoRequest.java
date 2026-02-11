package com.devsenior.svacca.proyecto.model.dto;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductoRequest {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotNull(message = "El precio es requerido")
    private Double precio;

    private String descripcion;

    @NotNull
    @Size(min = 1)
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
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
