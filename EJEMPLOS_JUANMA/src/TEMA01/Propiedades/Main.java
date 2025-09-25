package TEMA01.Propiedades;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileReader reader;

        try{
            reader = new FileReader("config.propiedades");
            Properties properties = new Properties();
            properties.load(reader);
            String nombre = properties.getProperty("nombre");
            System.out.println(nombre);
            String ip = properties.getProperty("ip");
            System.out.println(ip);
            String puerto = properties.getProperty("puerto");
            System.out.println(puerto);

            System.out.println("--------------------");

            properties.setProperty("nota", "notable");
            properties.store(new BufferedWriter(new FileWriter("config.propiedades")), "");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
