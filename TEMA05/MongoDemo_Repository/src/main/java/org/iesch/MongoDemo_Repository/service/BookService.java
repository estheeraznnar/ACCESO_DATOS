package org.iesch.MongoDemo_Repository.service;

import org.iesch.MongoDemo_Repository.modelo.Book;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

     @Autowired
    MongoTemplate mongoTemplate;

     //nulable es que puede devolver nulos
    public List<Book> findByTituloContainingIgnoreCase(String titulo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("titulo").regex(titulo, "i"));
        return mongoTemplate.find(query, Book.class);

    }

    public @Nullable List<Book> findByCategoriaContainingIgnoreCase(String cat) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categorias").regex(cat, "i"));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> findByNombreAutorContainingIgnoreCase(String nombre) {
        Query query = new Query();
        query.addCriteria(Criteria.where("autores.nombre").is(nombre));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> findByPrecioEntre(Double min, Double max) {
        Query query = new Query();
        query.addCriteria(Criteria.where("precio").gte(min).lte(max));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> findByAnioPublicacionReciente(Integer anio) {
        Query query = new Query();
        query.addCriteria(Criteria.where("anioPublicacion").gt(anio));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> findByAPrecioAnio(Double precio, Integer anio) {
        Query query = new Query();
        query.addCriteria(Criteria.where("precio").lt(precio).and("anioPublicacion").gt(anio));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> findByTituloCategoria(String titulo, String categorias) {
        Query query = new Query();
        query.addCriteria(Criteria.where("titulo").regex(titulo, "i").and("categorias").in(categorias));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> buscarPorCategoriasMultiples(List<String> categoriasMultiples) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categorias").in(categoriasMultiples));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> buscarPorPrecioMaxOrdenado(Double precio) {
        Query query = new Query();
        query.addCriteria(Criteria.where("precio").lte(precio));
        query.with(Sort.by(Sort.Direction.DESC, "anioPublicacion"));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable List<Book> buscarPorMultiplesAutores() {
        Query query = new Query();
        query.addCriteria(Criteria.where("autores.1") //el .1 es para decir que debe de tener mas de uno
                .exists(true));
        return mongoTemplate.find(query, Book.class);
    }

    public @Nullable Long contarPorCategoria(String categoria) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categorias").regex(categoria, "i"));
        return mongoTemplate.count(query, Book.class); //en este es count para que cuente cuantas veces esta y es lo q mostrara
    }
}
