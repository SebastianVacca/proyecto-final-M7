package com.devsenior.svacca.proyecto.service;

import java.util.List;

import com.devsenior.svacca.proyecto.model.dto.ProductoRequest;
import com.devsenior.svacca.proyecto.model.dto.ProductoResponse;

public interface ProductoService {

    ProductoResponse guardarProducto(ProductoRequest producto);

    ProductoResponse actualizarProducto(ProductoRequest producto);

    List<ProductoResponse> obtenerTodos();

    ProductoResponse obtenerPorId(String id);

    List<ProductoResponse> obtenerPorNombre(String textoBUsqueda);

    List<ProductoResponse> obtenerPorTag(String textoBUsqueda);

    List<ProductoResponse> obtenerPorEspecifiacion(String key, String value);

    void eliminarPorId(String id);

}
