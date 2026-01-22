package org.iesch.MongoDemo_Repository.repositorio;

import org.iesch.MongoDemo_Repository.modelo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    //======== QUERY METHODS ==========


    /**
     * Buscar libros por titulos (ignorando mayusculas y minusculas)
     */
    List<Book> findByTituloContainingIgnoreCase (String titulo);

    /**
     * Buscar libros por categoria (ignorando mayusculas y minusculas)
     * Como categorias es una array, spring data buscara si contiene el elemento
     */
    List<Book> findByCategorias (String categorias);

    /**
     * Buscar libros por autores (ignorando mayusculas y minusculas)
     * documento embebido
     */
    List<Book> findByAutoresNombre (String autor);

    /**
     * Buscar los libros que esten en un rango de precios
     */
    List<Book> findByPrecioBetween (Double precioMin, Double precioMax);

    /**
     * Buscar los libros que se han publicado despues de un año concreto
     */
    List<Book> findByAnioPublicacionGreaterThan (Integer anioPublicacion);


    //======== QUERY PERSONALIZADOS ==========

    /**
     * Buscar por nombre de autor usando query mongo
     */
    @Query("{'autores.nombre': {$regex: ?0, $options: 'i'}}")
    List<Book> buscarPorAutoresNombre (String nombreAutores);

    /**
     * Buscar con un precio inferior a XXX y que se hayan publicaco despues del 2015
     */
    @Query("{'precio': {$lt:20}, 'anioPublicacion':{$gt:1965}}")
    List<Book> buscarPorPrecioInferiorYAnioMayor (Double precio, Integer anioPublicacion);


}
