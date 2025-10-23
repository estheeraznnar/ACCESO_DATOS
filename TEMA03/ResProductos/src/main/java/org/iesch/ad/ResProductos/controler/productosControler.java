package org.iesch.ad.ResProductos.controler;

import org.iesch.ad.ResProductos.modelo.Producto;
import org.iesch.ad.ResProductos.service.ProductosService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class productosControler {
    private static final Logger looger = LoggerFactory.getLogger(productosControler.class);

    @Autowired
    Map<Long, Producto> productos;

    @Autowired
    ProductosService productosService;

    @GetMapping("/producto")
    public ResponseEntity<?> getTodos(){
        if (productos.isEmpty()){
            return ResponseEntity.notFound().build();//el build es por el patron builder
        }else {
            return ResponseEntity.ok(productos);
        }
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        looger.debug("Buacando el producto con Id: {}", id);//debug
        Producto producto = productosService.getOne(id);

        if (producto == null){
            looger.warn("Producto cont Id {} no encontrado", id);
            return ResponseEntity.notFound().build();//el build es por el patron builder
        }else {
            return ResponseEntity.ok(productos); //DEVUELVE 200 si existe y 404 si no existe
        }
    }
    @PostMapping("/producto")
    public ResponseEntity<?> addOne(@RequestBody Producto producto){
        looger.info("Creando un nuevo producto: {}", producto); //info
        productosService.addOne(producto);
        //return ResponseEntity.status(HttpStatus.CREATED).body(producto);// de esta forma no muestra el location
        URI location = URI.create("/producto/" + producto.getId());
        return ResponseEntity.created(location).body(producto); //de esta forma sale location
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> updateOne(@RequestBody Producto producto, @PathVariable Long id){
        looger.info("Modificando el producto con id: {}", producto);
        looger.debug("Datos: {}", producto);
        Producto productoTemp = productosService.updateOne(producto, id);

        if (productoTemp == null){
            looger.warn("Producto cont Id {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }else {

        return ResponseEntity.ok(productoTemp);
        }

    }

    @DeleteMapping ("/producto/{id}") //204
    public ResponseEntity<?> deleteOne(@PathVariable Long id){

        looger.info("Eliminando el producto con id {}", id);
        Producto productoTemp = productosService.deleteOne(id);

        if (productoTemp == null){
            looger.warn("Producto cont Id {} no encontrado", id);
            return ResponseEntity.notFound().build();//404
        }else {

            return ResponseEntity.noContent().build();//404
        }
    }

}
