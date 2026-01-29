package org.iesch.MongoDemo_Repository.controller;

import org.iesch.MongoDemo_Repository.modelo.Book;
import org.iesch.MongoDemo_Repository.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Buscar libros por Titulo y categoria
     * Titulo ->String, regex
     * Categoria es String[]
     * GET api/books/template/search/titulo-categoria?titulo=XXXX&categoria=ZZZZ
     */

    @GetMapping("/search/titulo-categoria")
    public ResponseEntity<List<Book>> buscarPorTituloCategoria(@RequestParam String titulo, @RequestParam String  categorias){
        return ResponseEntity.ok(bookService.findByTituloCategoria(titulo, categorias));
    }

    /**
     * Buscar por multiples categorias
     * Body: ["Programacion", "Java"]
     * Envio un array en vez de string
     * POST api/books/template/search/categorias-multiples
     */
    @PostMapping("/search/categorias-multiples")
    public ResponseEntity<List<Book>> buscarPorMultiplesCategorias(@RequestBody List<String> categoriasMultiples){
        return ResponseEntity.ok(bookService.buscarPorCategoriasMultiples(categoriasMultiples));
    }

    /**
     * Buscar por precio maximo ordenado por año desc.
     * GET api/books/template/search/precio-maximo-ordenado?precio=XXXX
     */
    @GetMapping("/search/precio-maximo-ordenado")
    public ResponseEntity<List<Book>> buscarPorPrecioMaxOrdenado(@RequestParam Double precio){
        return ResponseEntity.ok(bookService.buscarPorPrecioMaxOrdenado(precio));
    }

    /**
     * Buscar libros que tengan multipes autores
     * GET api/books/template/search/multiples-autores
     * la hacemos sin pasarle ningun parametro
     */
    @GetMapping("/search/multiples-autores")
    public ResponseEntity<List<Book>> buscarPorMultiplesAutores(){
        return ResponseEntity.ok(bookService.buscarPorMultiplesAutores());
    }

    /**
     * Contar lobros por categoria (cuantos libros hay en x categoria)
     * Get api/books/template/search/contar-categoria?categoria=XXXX
     * Tendra que ser Long para que lo pueda contar ya que si es un lista no puede contar
     */
    @GetMapping("/search/contar-categoria")
    public ResponseEntity<Long> contarPorCategoria(@RequestParam String categoria){
        return ResponseEntity.ok(bookService.contarPorCategoria(categoria));
    }

}
