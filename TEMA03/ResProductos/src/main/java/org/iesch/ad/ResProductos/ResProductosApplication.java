package org.iesch.ad.ResProductos;

import org.iesch.ad.ResProductos.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ResProductosApplication /*implements CommandLineRunner*/ {

	/*@Autowired
	List<Producto> productos;*/
	public static void main(String[] args) {
		SpringApplication.run(ResProductosApplication.class, args);
	}


	/*@Override
	public void run(String... args) throws Exception {
		System.out.println(productos);
	}*/
}
