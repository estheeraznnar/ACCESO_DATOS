package org.iesch.ad.Ej2.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String creador;
    String comentario;
    LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false);
    private Post post;
}
