package org.iesch.ad.demoJPA_coches.controler;

import org.iesch.ad.demoJPA_coches.modelo.Coche;
import org.iesch.ad.demoJPA_coches.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
public class CocheControlador {

    @Autowired
    CocheService cocheService;

    @PostMapping
    public ResponseEntity<Coche> guardar(@RequestBody Coche coche){

        Coche cocheGuardado = cocheService.guardar(coche);

        return ResponseEntity.ok(cocheGuardado);
    }

    @GetMapping
    public ResponseEntity<List<Coche>> obtenerTodos(){
        return ResponseEntity.ok(cocheService.obtenerTodos());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Coche> obtenerUno(@PathVariable Long id){
        return ResponseEntity.ok(cocheService.obtenerUno(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Coche> actualizaUno(@PathVariable Long id, Coche coche){
        return ResponseEntity.ok(cocheService.updateUno(id, coche));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Coche> borrarUno(@PathVariable Long id){

        Coche cocheBorrrado =cocheService.borrarUno(id);
        if (cocheBorrrado == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/buscaporcolor/{color}")
    public ResponseEntity <List<Coche>> obtenerPorColor(@PathVariable String color){

        return ResponseEntity.ok(cocheService.obtenerPorColor(color));
    }

    @GetMapping ("/buscaporcolorymarca/{color}/{marca}")
    public ResponseEntity <List<Coche>> obtenerPorColorYMarca(@PathVariable String color, @PathVariable String marca){

        return ResponseEntity.ok(cocheService.obtenerPorColorYMarca(color, marca));
    }
    @GetMapping ("/buscaporcolorymarcaypotenciamenor/{color}/{marca}/{potencia}")
    public ResponseEntity <List<Coche>> obtenerPorColorYMarcaPotenciaMenor(@PathVariable String color, @PathVariable String marca, @PathVariable int potencia){

        return ResponseEntity.ok(cocheService.obtenerPorColorYMarcaPotenciaMenor(color, marca, potencia));
    }
}
