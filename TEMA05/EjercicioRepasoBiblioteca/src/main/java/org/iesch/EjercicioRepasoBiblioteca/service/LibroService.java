package org.iesch.EjercicioRepasoBiblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Buscar libros que contengan cualquiera de las categorías pasadas
     */
    public List<Libro> buscarPorCategoriasMultiples(List<String> categorias) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categorias").in(categorias));
        return mongoTemplate.find(query, Libro.class);
    }

    /**
     * Buscar libros con precio menor o igual a precioMax
     * Ordenados por año de publicación descendente
     */
    public List<Libro> buscarPorPrecioMaximoOrdenado(Double precioMax) {
        Query query = new Query();
        query.addCriteria(Criteria.where("precio").lte(precioMax));
        query.with(Sort.by(Sort.Direction.DESC, "anioPublicacion"));
        return mongoTemplate.find(query, Libro.class);
    }

    /**
     * Buscar libros que tengan más de un autor
     * autores.1 significa que existe el segundo elemento del array (índice 1)
     */
    public List<Libro> buscarLibrosConMultiplesAutores() {
        Query query = new Query();
        query.addCriteria(Criteria.where("autores.1").exists(true));
        return mongoTemplate.find(query, Libro.class);
    }
}