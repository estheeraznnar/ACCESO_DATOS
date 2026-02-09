package org.iesch.DocumentosReferenciados.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iesch.DocumentosReferenciados.modelo.BookRef;
import org.iesch.DocumentosReferenciados.service.BookRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "BookRefTemplateController", description = "Api para la gestion de libros referenciados")
@RestController
@RequestMapping("/api/books/template")
public class BookRefTemplateController {

    ///////CRUD

    @Autowired
    BookRefService bookRefService;

    /**
     * GetAll
     */
    @Operation(summary = "Este metodo obtiene todos los libros",
    description = "devuelve la lista completa de libros referenciados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se encuentran los libros correctamente")
    })
    @GetMapping
    public ResponseEntity<List<BookRef>> getAll(){
        return ResponseEntity.ok(bookRefService.buscarTodos());
    }

    @Operation(summary = "Este metodo obtiene el libro pasando el id",
            description = "Devuelve un libro referenciado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se encuentran el libro correctamente"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookRef> getOne(
            @Parameter(description = "Id del libro", required = true, example = "15gf4s5a4d1")
            @PathVariable String id){
        return ResponseEntity.ok(bookRefService.buscarPorId(id));
    }

    /**
     * Buscar por titulo
     */
    @GetMapping("/search/titulo")
    public ResponseEntity<List<BookRef>> getPorTitulo(@RequestParam String titulo){
        return ResponseEntity.ok(bookRefService.buscarPorTitulo(titulo));
    }

    /**
     * Buscar por id autor
     */
    @GetMapping("/search/autor/{autorId}")
    public ResponseEntity<List<BookRef>> getPorautorId(@PathVariable String autorId){
        return ResponseEntity.ok(bookRefService.findByAutoresId(autorId));
    }

    /**
     * Buscar libros de autor especifio (por nombre) usar lookup
     */
    @GetMapping("/search/autor-nombre")
    public ResponseEntity<List<BookRef>> buscarPorNombreAutor(@RequestParam String nombre){
        return ResponseEntity.ok(bookRefService.findByNombreAutor(nombre));
    }

}
