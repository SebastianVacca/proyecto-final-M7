package com.devsenior.svacca.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.devsenior.svacca.proyecto.model.document.Producto;
import com.devsenior.svacca.proyecto.model.dto.ProductoRequest;
import com.devsenior.svacca.proyecto.model.dto.ProductoResponse;

@Component
public class ProductoMapper {

    public Producto toDocument(ProductoRequest producto){
        var response = new Producto();
        response.setNombre(producto.getNombre());
        response.setPrecio(producto.getPrecio());
        response.setDescripcion(producto.getDescripcion());
        response.setTags(producto.getTags());
        response.setEspecificaciones(producto.getEspecificaciones());

        return response;
    }

    public ProductoResponse toResponse(Producto document){
        var response = new ProductoResponse();
        response.setId(document.getId());
        response.setNombre(document.getNombre());
        response.setPrecio(document.getPrecio());
        response.setDescripcion(document.getDescripcion());
        response.setTags(document.getTags());
        response.setEspecificaciones(document.getEspecificaciones());

        return response;
    }
}
