package org.iesch.ad.Ejercicio01.service;

import org.iesch.ad.Ejercicio01.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductoService {

    @Autowired
    Map<Long, Producto> productos;

    public Producto getOne(Long id){
        Producto producto = productos.get(id);
        return  producto;
    }

}
