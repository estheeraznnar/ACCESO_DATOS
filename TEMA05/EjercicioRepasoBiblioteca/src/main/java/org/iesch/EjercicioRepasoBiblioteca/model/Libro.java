package org.iesch.EjercicioRepasoBiblioteca.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "libros")
public class Libro {

    @Id
    private String id;
    private String titulo;
    private Integer anioPublicacion;
    private Double precio;
    private List<Autor> autores;
    private List<String> categorias;
    private String editorial;

    public Libro(String titulo, Integer anioPublicacion, Double precio,
                 List<Autor> autores, List<String> categorias, String editorial) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
        this.autores = autores;
        this.categorias = categorias;
        this.editorial = editorial;
    }
}
