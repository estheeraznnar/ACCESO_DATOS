package org.iesch.ad.Ev1_Ej3.repository;

import org.iesch.ad.Ev1_Ej3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //Ejercicio3 encontrar todos los clientes que han realizado pedidos en una fecha especifica
    @Query(value = "SELECT c FROM cliente c INNER JOIN pedidos p ON c.id = p.cliente_id WHERE p.fecha = :fecha", nativeQuery = true)
    List<Cliente> encontrarClientePorFecha(@Param("fecha") LocalDate fecha);
}
