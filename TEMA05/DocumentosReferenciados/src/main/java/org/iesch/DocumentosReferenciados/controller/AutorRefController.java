package org.iesch.DocumentosReferenciados.controller;

import org.iesch.DocumentosReferenciados.modelo.AutoresRef;
import org.iesch.DocumentosReferenciados.repository.AutoresRefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/autores")
public class AutorRefController {

    @Autowired
    AutoresRefRepository autoresRefRepository;
    /// ///////////CRUD AUTORES////////////

    /**
     * GETALL
     * GET /api/autores
     */
    @GetMapping
    public ResponseEntity<List<AutoresRef>> getAllAutores(){
        return ResponseEntity.ok(autoresRefRepository.findAll());
    }

    /**
     * GET ONE
     * GET /api/autores{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<AutoresRef> getOneAutore(@PathVariable String  id){
        Optional<AutoresRef> autor = autoresRefRepository.findById(id);
        return autor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear un nuevo autor
     * POST /api/autores
     */
    @PostMapping
    public ResponseEntity<AutoresRef> crearAutor(@RequestBody AutoresRef autor){
        AutoresRef autoresRef = autoresRefRepository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autoresRef);
    }

    /**
     * Modificar un autor
     * PUT /api/autores/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<AutoresRef> updateAutor(@PathVariable String id, @RequestBody AutoresRef autor){
        if (!autoresRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        autor.setId(id);
        AutoresRef autoresSave = autoresRefRepository.save(autor);
        return ResponseEntity.ok(autoresSave);
    }

    /**
     * Borrar autor
     * Si se borrar un autor los libros referenciados no se borran se quedan huerfanos
     *  Se deberia validar y eliminar en cascada si se elimina un autor (se deberia de hacer en un service) HACER EN CASA
     * DELETE /api/autores/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<AutoresRef> deleteAutor(@PathVariable String id, @RequestBody AutoresRef autoresRef){
        if (!autoresRefRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        autoresRefRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
