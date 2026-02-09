package org.iesch.DocumentosReferenciados.repository;

import org.iesch.DocumentosReferenciados.modelo.AutoresRef;
import org.iesch.DocumentosReferenciados.modelo.BookRef;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRefRepository extends MongoRepository<BookRef, String > {

    /**
     * Buscar libtos por el id del autor
     */
    List<BookRef> findByAutoresId(String id);

    //Consulta con @Query
    /**
     * Buscar libros con precio inferior a zzz y año de publicacion mayor a yyyyy
     */
    @Query("{'precio': {$lt: ?0}, 'anioPublicacion': {$gt: ?1}}")
    List<BookRef> buscarPorPrecioInfYAnioSup(Double precio, Integer anio);

    @Query("{$or: [{'precio': {$lt: ?0}}, {'anioPublicacion': {$gt: ?1}}]}")
    @Nullable List<BookRef> buscarEconomicosOAntiguos(Double precio, Integer anio);
}
