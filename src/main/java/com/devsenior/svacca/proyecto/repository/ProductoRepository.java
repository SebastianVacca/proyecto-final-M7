package com.devsenior.svacca.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.svacca.proyecto.model.document.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    boolean existsByName(String nombre);

}
