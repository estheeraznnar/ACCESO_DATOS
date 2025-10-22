package org.iesch.ad.ResProductos.controler;

import org.iesch.ad.ResProductos.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class productosControler {

    @Autowired
    Map<Long, Producto> productos;

    @GetMapping("/producto")
    public ResponseEntity<?> getTodos(){
        if (productos.isEmpty()){
            return ResponseEntity.notFound().build();//el build es por el patron builder
        }else {
            return ResponseEntity.ok(productos);
        }
    }

    @GetMapping("/producto")
    public ResponseEntity<?> getTodos(){
        if (productos.isEmpty()){
            return ResponseEntity.notFound().build();//el build es por el patron builder
        }else {
            return ResponseEntity.ok(productos);
        }
    }

}
