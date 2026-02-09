package com.devsenior.svacca.proyecto.service;

import java.util.List;

import com.devsenior.svacca.proyecto.model.dto.ProductoRequest;
import com.devsenior.svacca.proyecto.model.dto.ProductoResponse;

public interface ProductoService {

    ProductoResponse guardarProducto(ProductoRequest producto);

    List<ProductoResponse> obtenerTodos();

    ProductoResponse obtenerPorId(String id);

    void eliminarPorId(String id);

}
