package com.devsenior.svacca.proyecto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.svacca.proyecto.model.dto.ProductoRequest;
import com.devsenior.svacca.proyecto.model.dto.ProductoResponse;
import com.devsenior.svacca.proyecto.service.ProductoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping
    public ProductoResponse crearProducto(@Valid @RequestBody ProductoRequest producto) {
        return productoService.guardarProducto(producto);
    }
    
    @GetMapping
    public List<ProductoResponse> traerProductos() {
        return productoService.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public ProductoResponse traerPorId(@PathVariable String id) {
        return productoService.obtenerPorId(id);
    }

    @GetMapping("/buscar")
    public List<ProductoResponse> buscarPorNombre(@RequestParam String param) {
        return productoService.obtenerPorNombre(param);
    }

    @GetMapping("/por-tag")
    public List<ProductoResponse> buscarPorTag(@RequestParam String param) {
        return productoService.obtenerPorTag(param);
    }

    @GetMapping("/especificacion")
    public List<ProductoResponse> buscarPorEspecificacion(@RequestParam String key, String value) {
        return productoService.obtenerPorEspecifiacion(key, value);
    }
    
 
    @PutMapping("/{id}")
    public ProductoResponse putMethodName(@PathVariable String id,@Valid @RequestBody ProductoRequest producto) {
        return productoService.actualizarProducto(producto);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable String id) {
        productoService.eliminarPorId(id);
    }
}
