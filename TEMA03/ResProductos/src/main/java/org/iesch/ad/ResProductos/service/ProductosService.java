package org.iesch.ad.ResProductos.service;

import org.iesch.ad.ResProductos.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class ProductosService {

    @Autowired
    Map<Long, Producto> productos;

    public Producto getOne(Long id) {

        Producto producto = productos.get(id);
        //System.out.println(producto);
        return producto;

    }

    public  void addOne(Producto producto){
        Long maxKey = Collections.max(productos.keySet());
        producto.setId(maxKey+1);
        productos.put(maxKey + 1, producto);
    }

    public Producto updateOne(Producto producto, Long id) {
        Producto productoTmp = productos.get(id);
        if (productoTmp == null){
            return null;
        }else {
            producto.setId(id);
            productos.put(id, producto);
            return producto;
        }

    }

    public Producto deleteOne(Long id) {
        Producto productoTmp = productos.get(id);
        if (productoTmp == null){
            return null;
        }else {
            productos.remove(id);
            return productoTmp;
        }
    }
}
