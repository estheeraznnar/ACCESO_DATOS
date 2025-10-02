package Reggex.Ejer02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Validar un número de teléfono:
Descripción: Validar si una cadena es un número de teléfono en el formato (XXX) XXX-
XXXX.*/
public class Main {

    public static void main(String[] args) {
        String numeros = "Ejemplo de texto con direcciones IP: El servidor principal tiene la dirección IP 639 75 67 19  y 978 75 86 32, 655 38 68 58 se comunica con los servidores de seguridad en 192.168.1.10 y 192.168.1.11. Para el acceso remoto, se utiliza la dirección IPv6 2001:db8:85a3::8a2e:370:7334. La página del administrador, admin.ejemplo.com, está asignada a la dirección 10.0.0.5 y está sujeta a las directivas de seguridad aplicadas a todas las máquinas en el rango de red. ";

        //1 Extrar los Telefonos
        extraerNumeros(numeros);
    }

    private static void extraerNumeros(String numeros) {

        Pattern pattern = Pattern.compile("\\b(6|7|8|9)\\d{2}[\\s-]?\\d{2}[\\s-]?\\d{2}[\\s-]?\\d{2}\\b");
        Matcher matcher = pattern.matcher(numeros);
        while (matcher.find()){
            System.out.println("Telefono: " + matcher.group());
        }

    }

}
