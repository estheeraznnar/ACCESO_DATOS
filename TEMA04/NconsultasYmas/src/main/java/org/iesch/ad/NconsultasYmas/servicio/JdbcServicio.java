package org.iesch.ad.NconsultasYmas.servicio;

import org.iesch.ad.NconsultasYmas.modelo.Libro;
import org.iesch.ad.NconsultasYmas.repositorio.JdbcTemplateRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JdbcServicio {
        @Autowired
        private JdbcTemplateRepositorio jdbcTemplateRepositorio;

    public void demoConsultasJDBCTemplate() {

        System.out.println("buscar libros de autores argentinos");
        List<Libro> librosArgentinos = jdbcTemplateRepositorio.finLibrosPorNacionalidadAutor("Argentina");

        librosArgentinos.forEach(libro ->
                        System.out.printf(". '%s' por %s %s (%.2f€, %d) %n",
                                libro.getTitulo(),
                                libro.getAutor().getNombre(),
                                libro.getAutor().getApellido(),
                                libro.getPrecio(),
                                libro.getAnioPublicacion()
                                )

                );


        System.out.println("-".repeat(50));
        System.out.println("Estadisticas de libros por autor");
        List<Map<String, Object>> estadisticas = jdbcTemplateRepositorio.getEstadisticasLibrosPorAutor();

        estadisticas.forEach(estadistica->{

                    System.out.printf("P %s %s (%s):%n",
                            estadistica.get("nombre"),
                            estadistica.get("apellido"),
                            estadistica.get("nacionalidad")
                    );


                    System.out.printf("Libros: %d | precio promedio: %.2f€ | Promedio: %s-%s%n%n",
                            estadistica.get("total_libros"),
                            estadistica.get("precio_promedio"),
                            estadistica.get("primer_libro"),
                            estadistica.get("ultimo_libro")
                    );
        });

        System.out.println("...Libros por rango de pricio y año.");
        System.out.println("...Libros entre 12 y 18€ publicados desde 1960");
        System.out.println(" - ". repeat(50));

        List<Libro> librosCaros = jdbcTemplateRepositorio.encontrarLibrosPorPrecioYAnio(12.0, 18.0, 1960);
        librosCaros.forEach(libro -> System.out.printf(" '%s' - %.2f€ (%d) por %s %s%n",
                libro.getTitulo(),
                libro.getPrecio(),
                libro.getAnioPublicacion(),
                libro.getAutor().getNombre(),
                libro.getAutor().getApellido()
        ));

        System.out.println("\n Fin");

    }
}
