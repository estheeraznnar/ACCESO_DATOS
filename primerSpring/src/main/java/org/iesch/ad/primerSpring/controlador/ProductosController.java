package org.iesch.ad.primerSpring.controlador;

import org.iesch.ad.primerSpring.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

@RestController
//To do lo que se creen en esta clase llevara /api delante en el mapping
@RequestMapping("/api")
public class ProductosController {
    //Lo que use con nombre en este documento me buscara en propierties si hay algun nombre y usara ese nombre
    @Value("${name}")
    String nombre;
    @Value("${app.version}")
    private String version;

    @PostMapping("/producto")
    public void recibeProducto(@RequestBody Producto producto){

        System.out.println(producto);
        System.out.println(nombre);
        System.out.println(version);


    }

    @GetMapping("/producto")
    public Producto dameProducto(){
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setId(15);
        p.setPrecio(23.5f);
        return p;
    }

}
