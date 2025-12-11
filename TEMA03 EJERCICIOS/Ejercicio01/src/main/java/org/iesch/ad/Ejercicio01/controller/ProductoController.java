package org.iesch.ad.Ejercicio01.controller;

import org.iesch.ad.Ejercicio01.modelo.Producto;
import org.iesch.ad.Ejercicio01.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    public static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    Map<Long, Producto> productos;

    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ResponseEntity<?> getTodos(){
        if (productos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(productos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        logger.debug("Buscando el producto por id: " + id);
        Producto producto = productoService.getOne(id);

        if (producto == null){
            logger.warn("Producto con id {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(productos);
        }
    }
}
