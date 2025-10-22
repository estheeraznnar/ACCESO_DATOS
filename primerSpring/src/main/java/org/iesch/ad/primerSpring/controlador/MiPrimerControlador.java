package org.iesch.ad.primerSpring.controlador;

import org.iesch.ad.primerSpring.servicios.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//Es un controlador de clase res
@RestController
public class MiPrimerControlador {

    //Esto tambien es para que no haga falta poner new
    //funciona prque en la Clase Utils he puesto @service que sirve para poder usarlo en cualquier sitio
    @Autowired
    Utils utils;

    @GetMapping("/saludo")
    public String saludo(){
     return "Hola mundo";
    }

    //FORMA 1
    //{} Es para saber que tiene que cojer
    @GetMapping("/saluda/{nombre}")
    //variable que pasa por la ruta
    public String saludarA(@PathVariable String nombre){
        return "Hola " + nombre;
    }

    //FORMA 2 con JASON
    @GetMapping("/saludar/{nombre}")
    public Map<String, String> saludar(@PathVariable String nombre){
        Map<String, String> map = Map.of("Saludo", "Hola " + nombre);
        return map;
    }

    //FOMA 1 sin nada
    @GetMapping("/buscar")
    public Map<String, String> buscar(@RequestParam("nombre") String nombre){
        Map<String, String> map = Map.of("Saludo", "Buscamos a " + nombre);
        return map;
    }

    //FORMA 2 usando el servicios
    @GetMapping("/buscar2")
    public Map<String, String> buscar2(@RequestParam(required = true, name = "nombre") String nombre){
        String nomMayus = utils.transformarMayuscula(nombre);

        Map<String, String> map = Map.of("Saludo", "Buscamos a " + nomMayus);
        return map;
    }

}
