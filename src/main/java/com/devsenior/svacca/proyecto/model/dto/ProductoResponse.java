package com.devsenior.svacca.proyecto.model.dto;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProductoResponse {
    private String id;

    private String nombre;

    private Double precio;

    private String descripcion;

    private List<String> tags;

    @Field("especificaciones")
    private Map<String, Object> especificaciones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
