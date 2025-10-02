package Ficheros.Ejer07;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*Al ejercicio anterior, añádele una profundidad máxima, por ejemplo de 3, es decir si la
ruta que le has dicho es /home/Juanma, si la profundidad es 3 solo escanearía 3 niveles
de directorios interiores.*/
public class Main {

    public static void main(String[] args) {

        String ruta = "/usuarios/dam2/IdeaProjects";
        String patron = "*.java";
        String drectory = ruta;
        String pattern = patron.replace("*", ".*");
        int maxProfundidad = 3;

        List<Path> files = findFiles(drectory, pattern, maxProfundidad);
        for (Path file :files){
            System.out.println(file);
        }

    }

    private static List<Path> findFiles(String drectory, String pattern, int maxProfundidad) {

        List<Path> result = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(drectory), new SimpleFileVisitor<Path>(){
                private int currentDepth = 0;
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (currentDepth > maxProfundidad){
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                    currentDepth++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException ioException) throws IOException{
                    currentDepth--;
                    return FileVisitResult.CONTINUE;
                }
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
