package org.iesch.ad.Ej2.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String creador;
    String contenido;
    String rutaImagen;
    LocalDateTime fecha;

    @

    ArrayList<Comentario> comentarios = new ArrayList<>();


}
