package org.iesch.ad.primerSpring.controlador;

import org.iesch.ad.primerSpring.servicios.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*Ejercicio 2
    Servicio REST de conversión de unidades: Crea un servicio que reciba un valor y una unidad
    de medida, y devuelva la conversión a otra unidad de medida. Por ejemplo, convertir de
    grados Celsius a Fahrenheit o de kilómetros a millas. Debes pasar los datos a convertir al
    endpoint a través de un metodo get y como un valor pasado por variable (@PathVariable).*/
@RestController
public class ConvertidorController {
    //Esto lo que hace es decirle que hay una clase que con esa notacion tiene que crear ese contenedor cuando lo tenga q crear
    @Autowired
    Utils utils;

    /*Ejercicio 2.a*/
    @GetMapping ("/conDistanciaEJ2.a/{km}")
    public Double convertidorDistancias(@PathVariable int km){
        Double millas = 0d;
        millas = utils.convierteAMillas(km);

        return millas;
    }

    /*Ejercicio 2.b*/
    @GetMapping ("/conTempEJ2.b/{temp}")
    public double convertidorTemperatura(@PathVariable float temp){
        float fahrentheit = 0f;
        fahrentheit = utils.convertirAFahrentheit(temp);

        return fahrentheit;
    }
}
