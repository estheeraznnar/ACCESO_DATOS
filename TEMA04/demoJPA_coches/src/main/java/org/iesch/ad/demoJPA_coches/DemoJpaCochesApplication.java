package org.iesch.ad.demoJPA_coches;

import org.iesch.ad.demoJPA_coches.modelo.Persona;
import org.iesch.ad.demoJPA_coches.repositorio.CocheRepositorio;
import org.iesch.ad.demoJPA_coches.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoJpaCochesApplication implements CommandLineRunner {

	@Autowired
	PersonaRepositorio personaRepositorio;
	@Autowired
	CocheRepositorio cocheRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaCochesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception{

//		System.out.println("Muestra la persona 1");
		Persona personatmp = personaRepositorio.findById(1L).get();
		System.out.println(personatmp.getNombre());
		System.out.println(personatmp.getApellido());
		personatmp.getCoches().stream().forEach(System.out::println
		);

//		personatmp.getCoches().stream().forEach(System.out::println);

		//System.out.println(personaRepositorio.findById(1L).get());
//		System.out.println("Muestra coche 1");
//		System.out.println(cocheRepositorio.findById(1L).get());
	}

}
