package org.iesch.ad.demoValid.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotBlank //Nopuede estar el nombre en blanco
    @Size(min = 3, max = 25, message = "El nombre debe de tener entre 3 y 25 caracteres") //minimo y maximo de caracteres
    private String nombre;
    @NotBlank(message = "El email no puede estar vacio")
    private String email;

}
