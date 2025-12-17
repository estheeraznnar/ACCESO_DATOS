package org.iesch.ad.Ev1_Ej3.controlador;

import org.iesch.ad.Ev1_Ej3.model.Cliente;
import org.iesch.ad.Ev1_Ej3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControladorClientes {

    @Autowired
    private ClienteRepository clienteRepository;

    //Ejercicio2
    @GetMapping("/clientes")
    public List<Cliente> obtenerTodosLibros(){
        return clienteRepository.findAll();
    }

    //Ejercicio3
    @GetMapping("/clientesPorFecha")
    public List<Cliente> obtenerClientePorFecha(@RequestParam("fecha") LocalDate fecha){
        return clienteRepository.encontrarClientePorFecha(fecha);
    }

}
