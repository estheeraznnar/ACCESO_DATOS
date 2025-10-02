package Ficheros.Ejer06;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*Devuelve todas las rutas a partir de un directorio dado que cumplen una condición. Por
ejemplo, busca todos los archivos “*.txt”*/
public class Main {

    public static void main(String[] args) {

        String ruta = "src";
        String patron = "*.java";
        String drectory = ruta;
        String pattern = patron.replace("*", ".*");

        List<Path> files = findFiles(drectory, pattern);
        for (Path file :files){
            System.out.println(file);
        }

    }

    private static List<Path> findFiles(String drectory, String pattern) {

        List<Path> result = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(drectory), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
                    if (file.getFileName().toString().matches(pattern)){
                        result.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
