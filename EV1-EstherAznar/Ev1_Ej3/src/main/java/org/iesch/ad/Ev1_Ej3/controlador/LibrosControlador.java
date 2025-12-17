package org.iesch.ad.Ev1_Ej3.controlador;

import org.iesch.ad.Ev1_Ej3.model.Libro;
import org.iesch.ad.Ev1_Ej3.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibrosControlador {

    @Autowired
    private LibrosRepository librosRepository;

    @GetMapping("/librosPorEditorial")
    public List<Libro> obtenerLibroPorEditorial(@RequestParam("nombre") String nombre){
        return librosRepository.encontrarPorEditorial(nombre);
    }


}
