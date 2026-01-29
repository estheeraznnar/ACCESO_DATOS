package org.iesch.MongoDemo_Repository.controller;

import org.iesch.MongoDemo_Repository.modelo.Book;
import org.iesch.MongoDemo_Repository.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books/template")
public class BookTemplateController {

    @Autowired
    BookService bookService;

    // ========== Consultas basicas

    /**
     * Buscar libros por titulo
     * GET /api/books/template/search/titulo?q=titulo
     */
    @GetMapping("/search/titulo")
    public ResponseEntity<List<Book>> buscarPorTitulo(@RequestParam String q){
        return ResponseEntity.ok(bookService.findByTituloContainingIgnoreCase(q));
    }


    /**
     * Buscar libros por categoria
     * GET /api/books/template/search/categoria?cat=titulo
     */
    @GetMapping("/search/categoria")
    public ResponseEntity<List<Book>> buscarPorCategoria(@RequestParam String cat){
        return ResponseEntity.ok(bookService.findByCategoriaContainingIgnoreCase(cat));
    }

    /**
     * Buscar libros por autor
     * GET /api/books/template/search/autor?nombre=titulo
     */
    @GetMapping("/search/autor")
    public ResponseEntity<List<Book>> buscarPorAutor(@RequestParam String nombre){
        return ResponseEntity.ok(bookService.findByNombreAutorContainingIgnoreCase(nombre));
    }

    /**
     * GET api/books/template/search/precio?min=XX&max=YY
     * Buscar libros en un rango de precios
     */
    @GetMapping("/search/precio")
    public ResponseEntity<List<Book>> buscarPorPrecio(@RequestParam Double min, @RequestParam Double max){
        return ResponseEntity.ok(bookService.findByPrecioEntre(min, max));
    }

    /**
     * GET api/books/template/search/recientes?anio=XXXX  (la logica habria que hacerla en el service)
     * Buscar libros mas recientes a un año
     */
    @GetMapping("/search/recientes")
    public ResponseEntity<List<Book>> buscarPorRecientes(@RequestParam Integer anio){
        return ResponseEntity.ok(bookService.findByAnioPublicacionReciente(anio));
    }

    /**
     * GET api/books/template/search/precio-anio?precio=XXXX&anio=ZZZZ  (la logica habria que hacerla en el service)
     * Buscar libros con un precio inferior a xxxx y que se hayan publicado despues de un año zzzz
     */
    @GetMapping("/search/precio-anio")
    public ResponseEntity<List<Book>> buscarPorPrecioAnio(@RequestParam Double precio, @RequestParam Integer anio){
        return ResponseEntity.ok(bookService.findByAPrecioAnio(precio, anio));
    }

}
