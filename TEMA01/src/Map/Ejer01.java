package Map;

import java.util.HashMap;
import java.util.Map;

/*Crear un Map que asocie nombres de países con sus capitales. Luego,
imprimir todos los pares de clave-valor del Map.*/
public class Ejer01 {
    public static void main(String[] args) {
        Map<String, String> paisesCapitales = new HashMap<>();
        paisesCapitales.put("España", "Madrid");
        paisesCapitales.put("Francia", "Paris");
        paisesCapitales.put("Alemania", "Berlin");
        paisesCapitales.put("Italia", "Roma");
        paisesCapitales.put("Portugal", "lisboa");

        for (Map.Entry<String,String> entry : paisesCapitales.entrySet()){
            System.out.println("Pais: " + entry.getKey()+ "        Capital: " +entry.getValue());
        }

    }
}
