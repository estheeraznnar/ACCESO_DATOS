package org.iesch.MongoDemo_Repository.controller;

import org.iesch.MongoDemo_Repository.modelo.Book;
import org.iesch.MongoDemo_Repository.repositorio.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //CRUD

    //GETALL
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks (){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    //GET_ONE
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById (@PathVariable String id){
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //UPDATE. Actualizar un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable String id, @RequestBody Book book){
        if (!bookRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        Book updateBook = bookRepository.save(book);
        return ResponseEntity.ok(updateBook);
    }

    @PostMapping
    public ResponseEntity<Book> createBook (@RequestBody Book book){
        Book booksaved = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(booksaved);
    }

    //DELETE
    @DeleteMapping("/id")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        if (!bookRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * /api/books/search/titulo?q=....
     */
    @GetMapping("/search/titulo")
    public ResponseEntity<List<Book>> buscarPorTitulo(@RequestParam String q){
        return ResponseEntity.ok(bookRepository.findByTituloContainingIgnoreCase(q));
    }

    /**
     * /api/books/search/categoria?cat=....
     */
    @GetMapping("/search/categoria")
    public ResponseEntity<List<Book>> buscarPorCategoria(@RequestParam String cat){
        return ResponseEntity.ok(bookRepository.findByCategorias(cat));
    }

    /**
     * /api/books/search/autor?nombre=....
     * El nombre del autor esta en un documento embebido
     */

    @GetMapping("/search/autor")
    public ResponseEntity<List<Book>> buscarPorAutor(@RequestParam String nombre){
        return ResponseEntity.ok(bookRepository.findByAutoresNombre(nombre));
    }

    /**
     * /api/books/search/precio?min=....&max=....
     * El nombre del autor esta en un documento embebido
     */

    @GetMapping("/search/precio")
    public ResponseEntity<List<Book>> buscarPorPrecio(@RequestParam Double min, @RequestParam Double max){
        return ResponseEntity.ok(bookRepository.findByPrecioBetween(min, max));
    }

    /**
     * /api/books/search/recientes?anio=.....
     * El nombre del autor esta en un documento embebido
     */
    @GetMapping("/search/recientes")
    public ResponseEntity<List<Book>> buscarPorRecientes(@RequestParam Integer anio){
        return ResponseEntity.ok(bookRepository.findByAnioPublicacionGreaterThan(anio));
    }

    //======QUERYS PERSONALIZADAS =======
    /**
     * /api/books/search/nativo/autor?nombre=....
     * El nombre del autor esta en un documento embebido y hacemos uso de @query
     */
    @GetMapping("/search/nativo/autor")
    public ResponseEntity<List<Book>> buscarPorNombreAutorQuery(@RequestParam String nombre){
        return ResponseEntity.ok(bookRepository.buscarPorAutoresNombre(nombre));
    }

    /**
     * /api/books/search/nativo/precio?nombre=....
     * El nombre del autor esta en un documento embebido y hacemos uso de @query
     */
    @GetMapping("/search/nativo/precioAnio")
    public ResponseEntity<List<Book>> buscarPorPrecioMenorYAnioMayorQuery(@RequestParam Double precio, @RequestParam Integer anio){
        return ResponseEntity.ok(bookRepository.buscarPorPrecioInferiorYAnioMayor(precio, anio));
    }

}
