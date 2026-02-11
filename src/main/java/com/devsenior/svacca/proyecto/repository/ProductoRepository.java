package com.devsenior.svacca.proyecto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.devsenior.svacca.proyecto.model.document.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    boolean existsByNombre(String nombre);

    List<Producto> findByNombreContainingIgnoreCaseOrDescripcionContainingIgnoreCase(String nombre, String descripcion);

    List<Producto> findByTagsContaining(String tag);

    @Query("{ 'especificaciones.?0' : ?1 }")
    List<Producto> findByEspecificacionKeyAndValue(String key, Object value);

}
