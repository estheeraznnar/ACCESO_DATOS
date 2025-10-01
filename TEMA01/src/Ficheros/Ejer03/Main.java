package Ficheros.Ejer03;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*Cifrado y descifrado de archivos: Escribir un programa en Java que permita cifrar y
descifrar un archivo utilizando un algoritmo de cifrado. El programa debe tomar como
entrada el nombre del archivo de origen, el nombre del archivo de destino, y una clave de
cifrado. El cifrado debe ser reversible, es decir, el archivo cifrado debe poder ser
descifrado con la misma clave. Puedes usar el algoritmo de cifrado AES1*/
public class Main {

    public static void main(String[] args) {
        File archivoOrigien = new File("texto02.txt");
        FileInputStream entradaOrigen;

        try {
            //abrimos el archivo de lectura
            entradaOrigen = new FileInputStream(archivoOrigien);

            //creamos archivo para escritura
            File archivoDestino = new File("destinocifrado.txt");
            FileOutputStream salidaDestino = new FileOutputStream(archivoDestino);

            //Generamos una clave
            String clave = "MiClaveCifradoss";
            SecretKeySpec claveCifrada = new SecretKeySpec(clave.getBytes(StandardCharsets.UTF_8),"AES");

            //Iniciar el cifrador
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, claveCifrada);

            //CIFRAR
            //primero leemos el fichero
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            while ((bytesLeidos = entradaOrigen.read(buffer)) != -1){
                byte[] bytesCifrados = cipher.update(buffer, 0, bytesLeidos);
                //escribir en el fichero de salida
                salidaDestino.write(bytesCifrados);
            }

            byte[] bytesCifrados = cipher.doFinal();
            salidaDestino.write(bytesCifrados);

            System.out.println("texto02");
            System.out.println("Vamos a descifrar");
            //abrimos archivo encriptado
            FileInputStream entradaCifrado = new FileInputStream(archivoDestino);
            FileOutputStream salidaDescifrada = new FileOutputStream(new File("descifrado.txt"));

            //inicio el descifrador
            cipher.init(Cipher.DECRYPT_MODE, claveCifrada);

            //tratar el fichero cifrado
            while ((bytesLeidos = entradaCifrado.read(buffer)) != -1){
                byte[] bytesDesCifrados = cipher.update(buffer, 0, bytesLeidos);
                //escribir en el fichero de salida
                salidaDescifrada.write(bytesDesCifrados);
            }
            byte[] bytesDesCifrados = cipher.doFinal();
            salidaDestino.write(bytesDesCifrados);

            entradaCifrado.close();
            salidaDescifrada.close();

            System.out.println("descifrado");


        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }

}
