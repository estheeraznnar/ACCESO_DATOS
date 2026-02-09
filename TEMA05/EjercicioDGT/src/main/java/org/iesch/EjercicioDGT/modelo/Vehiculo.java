package org.iesch.EjercicioDGT.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection =  "vehiculos")
public class Vehiculo {

    @Id
    private String id;
    private String matricula;
    private String bastidor;
    private String marca;
    private String modelo;
    private String color;
    private String tipoVehiculo;
    private Integer anioFabricacion,



}
