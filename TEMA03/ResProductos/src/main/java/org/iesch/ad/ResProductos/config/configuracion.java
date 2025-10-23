package org.iesch.ad.ResProductos.config;

import org.iesch.ad.ResProductos.modelo.Producto;
import org.iesch.ad.ResProductos.modelo.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class configuracion {

    //@Bean
    /*public List<Producto> inicialize(){
        List<Producto> productos = new ArrayList<>();
        productos.put(Producto.builder().id(1).nombre("Fairy").categoria("Limpieza").precio(5.25).descripcion("Lavabajllas mano").stock(15).build());
        productos.put(Producto.builder().id(2).nombre("Chorizo").categoria("Alimentacion").precio(9.45).descripcion("chorizo denominacion de origen").stock(20).build());
        productos.put(Producto.builder().id(3).nombre("Jamon").categoria("Alimentacion").precio(60).descripcion("Jamon bellota").stock(30).build());
        productos.put(Producto.builder().id(4).nombre("Peine").categoria("Hijiene").precio(2.6).descripcion("cepillo de pelo").stock(60).build());
        productos.put(Producto.builder().id(5).nombre("Pan").categoria("Alimentacion").precio(1.20).descripcion("Con gluten").stock(50).build());
        productos.put(Producto.builder().id(6).nombre("Aceite").categoria("Alimentacion").precio(3.60).descripcion("aceite de oliva").stock(50).build());
        productos.put(Producto.builder().id(7).nombre("Gel").categoria("Hijiene").precio(4.10).descripcion("gel de cuerpo").stock(50).build());
        productos.put(Producto.builder().id(8).nombre("Pilas").categoria("Bazar").precio(2.60).descripcion("++A").stock(50).build());
        return productos;
    }*/
    @Bean
    public Map<Long, Producto> inicialize(){
        Map<Long, Producto> productos = new HashMap<>();
        productos.put(1L,Producto.builder().id(1).nombre("Fairy").categoria("Limpieza").precio(5.25).descripcion("Lavabajllas mano").stock(15).build());
        productos.put(2L,Producto.builder().id(2).nombre("Chorizo").categoria("Alimentacion").precio(9.45).descripcion("chorizo denominacion de origen").stock(20).build());
        productos.put(3L,Producto.builder().id(3).nombre("Jamon").categoria("Alimentacion").precio(60).descripcion("Jamon bellota").stock(30).build());
        productos.put(4L,Producto.builder().id(4).nombre("Peine").categoria("Hijiene").precio(2.6).descripcion("cepillo de pelo").stock(60).build());
        productos.put(5L,Producto.builder().id(5).nombre("Pan").categoria("Alimentacion").precio(1.20).descripcion("Con gluten").stock(50).build());
        productos.put(6L,Producto.builder().id(6).nombre("Aceite").categoria("Alimentacion").precio(3.60).descripcion("aceite de oliva").stock(50).build());
        productos.put(7L,Producto.builder().id(7).nombre("Gel").categoria("Hijiene").precio(4.10).descripcion("gel de cuerpo").stock(50).build());
        productos.put(8L,Producto.builder().id(8).nombre("Pilas").categoria("Bazar").precio(2.60).descripcion("++A").stock(50).build());
        return productos;
    }

    @Bean
    public Map<Long, Usuario> initUsuarios(){
        Map<Long, Usuario> usuarios = new HashMap<>();
        usuarios.put(1L, Usuario.builder().id(1L).nombre("Esther").apellido("Aznar").direccion("micasa").passwd("eaznard14").build());
        return usuarios;
    }


}
