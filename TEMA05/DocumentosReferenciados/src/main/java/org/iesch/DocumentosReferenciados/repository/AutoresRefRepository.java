package org.iesch.DocumentosReferenciados.repository;

import org.iesch.DocumentosReferenciados.modelo.AutoresRef;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoresRefRepository extends MongoRepository<AutoresRef, String > {

    /**
     * Buscar por nombre de autor ignorando mayusculas y minusculas...
     */
    List<AutoresRef> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Buscar por nacionalidad de autor ignorando mayusculas y minusculas...
     */
    List<AutoresRef> findByNacionalidadContainingIgnoreCase(String pais);

    /**
     * Buscar por nacionalidades
     */
    @Nullable List<AutoresRef> findByNacionalidadIn(List<String> paises);
}
