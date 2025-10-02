package Reggex.Ejer01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*1: Extraer todas las direcciones IP de un texto:
Descripción: Dado un texto, extraer todas las direcciones IP válidas.*/
public class Main {
    public static void main(String[] args) {
        String texto = "Ejemplo de texto con direcciones IP: El servidor principal tiene la dirección IP 172.16.254.1 y se comunica con los servidores de seguridad en 192.168.1.10 y 192.168.1.11. Para el acceso remoto, se utiliza la dirección IPv6 2001:db8:85a3::8a2e:370:7334. La página del administrador, admin.ejemplo.com, está asignada a la dirección 10.0.0.5 y está sujeta a las directivas de seguridad aplicadas a todas las máquinas en el rango de red. ";

        //1 Extrar las direcciones
        extraerDirecciones(texto);
    }

    private static void extraerDirecciones(String texto) {

        Pattern pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()){
            System.out.println("IP: " + matcher.group());
        }

    }
}
