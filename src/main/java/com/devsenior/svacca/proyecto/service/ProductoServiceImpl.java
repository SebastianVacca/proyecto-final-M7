package com.devsenior.svacca.proyecto.service;

import java.util.List;
import java.util.stream.Collectors;

import com.devsenior.svacca.proyecto.exception.ProductNotFoundException;
import com.devsenior.svacca.proyecto.exception.ProductoAlreadyExistException;
import com.devsenior.svacca.proyecto.mapper.ProductoMapper;
import com.devsenior.svacca.proyecto.model.dto.ProductoRequest;
import com.devsenior.svacca.proyecto.model.dto.ProductoResponse;
import com.devsenior.svacca.proyecto.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService{
    
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl (ProductoRepository productoRepository, ProductoMapper productoMapper){
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoResponse guardarProducto(ProductoRequest producto) {
        if (productoRepository.existsByName(producto.getNombre())){
            throw new ProductoAlreadyExistException();
        }

        var document = productoMapper.toDocument(producto);
        document = productoRepository.save(document);

        var response = productoMapper.toResponse(document);
        return response;
    }

    @Override
    public List<ProductoResponse> obtenerTodos() {
        return productoRepository.findAll().stream()
            .map(productoMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public ProductoResponse obtenerPorId(String id) {
        return productoRepository.findById(id)
            .map(productoMapper::toResponse)
            .orElseThrow(() -> new ProductNotFoundException());
    }

    @Override
    public void eliminarPorId(String id) {
        productoRepository.deleteById(id);
    }


}
