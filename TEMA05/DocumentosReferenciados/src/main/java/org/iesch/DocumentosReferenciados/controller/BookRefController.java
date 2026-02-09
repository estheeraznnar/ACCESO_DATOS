package org.iesch.DocumentosReferenciados.controller;

import org.iesch.DocumentosReferenciados.modelo.BookRef;
import org.iesch.DocumentosReferenciados.repository.BookRefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookRefController {

    @Autowired
    BookRefRepository bookRefRepository;
    /// ///////////CRUD BOOK////////////

    /**
     * GETALL
     * GET /api/books
     */
    @GetMapping
    public ResponseEntity<List<BookRef>> getAllBooks(){
        return ResponseEntity.ok(bookRefRepository.findAll());
    }

    /**
     * GET ONE
     * GET /api/books{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookRef> getOneBook(@PathVariable String  id){
        Optional<BookRef> book = bookRefRepository.findById(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear un nuevo libro
     * POST /api/books
     */
    @PostMapping
    public ResponseEntity<BookRef> crearBook(@RequestBody BookRef book){
        BookRef bookRef = bookRefRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRef);
    }

    /**
     * Modificar un autor
     * PUT /api/books/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookRef> updateBook(@PathVariable String id, @RequestBody BookRef book){
        if (!bookRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        BookRef bookSave = bookRefRepository.save(book);
        return ResponseEntity.ok(bookSave);
    }

    /**
     * Borrar autor
     * Si se borrar un autor los libros referenciados no se borran se quedan huerfanos
     *  Se deberia validar y eliminar en cascada si se elimina un autor (se deberia de hacer en un service) HACER EN CASA
     * DELETE /api/books/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<BookRef> deletebook(@PathVariable String id, @RequestBody BookRef bookRef){
        if (!bookRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        bookRefRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    /**
     * Buscar libros por id del autor
     */
    @GetMapping("/search/{autor_id}")
    public ResponseEntity<List<BookRef>> buscarLibroPorIdAutor(@PathVariable String autor_id){
        return ResponseEntity.ok(bookRefRepository.findByAutoresId(autor_id));
    }

    /**
     * Con @Query
     * Buscar libros con precio inferior a zzz y año de publicacion mayor a yyyyy
     */
    @GetMapping("/search/precio-anio")
    public ResponseEntity<List<BookRef>> buscarPorPrecioYAnio(@RequestParam Double precio, @RequestParam Integer anio){
        return ResponseEntity.ok(bookRefRepository.buscarPorPrecioInfYAnioSup(precio, anio));
    }

    /**
     *
     */
    @GetMapping("/search/economicos-antiguos")
    public ResponseEntity<List<BookRef>> buscarPorEconomicosAntiguos(@RequestParam Double precio, @RequestParam Integer anio){
        return ResponseEntity.ok(bookRefRepository.buscarEconomicosOAntiguos(precio, anio));
    }

}
