package org.iesch.ad.primerSpring.controlador;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*Creación de un servicio REST para una calculadora: Implementa endpoints para realizar
operaciones matemáticas básicas como suma, resta, multiplicación y división. Los
parámetros de entrada y la respuesta pueden ser enviados en formato JSON.*/

//Es un controlador de clase res
@RestController
public class Calculadora {

    @PostMapping("/operacion/suma")
    public Map<String, Double> suma(@RequestBody Map<String, List<Double>> body){
        List<Double> valores = body.get("valores_suma");
        double res = valores.stream()
                .mapToDouble(Double::doubleValue).sum();
        return Map.of("resultado", res);
    }

    @PostMapping("/operacion/resta")
    public Map<String, Double> resta(@RequestBody Map<String, List<Double>> body) {
        List<Double> valores = body.get("valores_resta");
        double res = valores.get(0);
        for (int i = 1; i < valores.size(); i++) {
            res -= valores.get(i);
        }
        return Map.of("resultado", res);
    }

    @PostMapping("/operacion/multiplica")
    public Map<String, Double> multi(@RequestBody Map<String, List<Double>> body) {
        List<Double> valores = body.get("valores_multi");
        double res = valores.stream()
                .mapToDouble(Double::doubleValue)
                .reduce(1, (a,b)-> a * b);
        return Map.of("resultado", res);
    }

    @PostMapping("/operacion/div")
    public Map<String, Double> division(@RequestBody Map<String, List<Double>> body) {
        List<Double> valores = body.get("valores_division");
        double res = valores.get(0);
        for (int i = 1; i < valores.size(); i++) {
            res /= valores.get(i);
        }
        return Map.of("resultado", res);
    }

}
